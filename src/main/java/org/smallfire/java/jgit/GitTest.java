package org.smallfire.java.jgit;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * JGit API测试
 */
public class GitTest {

    public String remotePath = "git@toongitlab.syswin.com:gov_bjtoon/bjtoon-social-insurance.git";//远程库路径
    public String localPath = "F:\\jgit\\";//下载已有仓库到本地路径
    public String initPath = "F:\\jgit\\";//本地路径新建

    public static final String USER_NAME = "144637";
    public static final String PASS_WORD = "2wsx$RFV";


    /**
     * 克隆远程库
     *
     * @throws IOException
     * @throws GitAPIException
     */
    @Test
    public void testClone() throws IOException, GitAPIException {
        //设置远程服务器上的用户名和密码
        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider(USER_NAME, PASS_WORD);

        //克隆代码库命令
        CloneCommand cloneCommand = Git.cloneRepository();

        Git git = cloneCommand.setURI(remotePath) //设置远程URI
                .setBranch("develop") //设置clone下来的分支
                .setDirectory(new File(localPath)) //设置下载存放路径
                .setCredentialsProvider(usernamePasswordCredentialsProvider) //设置权限验证
                .call();

        System.out.print(git.tag());
    }

    /**
     * 本地新建仓库
     */
    @Test
    public void testCreate() throws IOException {
        //本地新建仓库地址
        Repository newRepo = FileRepositoryBuilder.create(new File(initPath + "/.git"));
        newRepo.create();
    }

    /**
     * 本地仓库新增文件
     */
    @Test
    public void testAdd() throws IOException, GitAPIException {

        File myfile = new File(localPath + "/myFile.txt");
        myfile.createNewFile();

        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider(USER_NAME, PASS_WORD);
        //git仓库地址
        try (Git git = Git.open(new File(localPath))) {
            git.pull().setRemoteBranchName("develop").
                    setCredentialsProvider(usernamePasswordCredentialsProvider).call();

            //添加文件
            git.add().addFilepattern("myFile").call();

            git.close();
        }


    }

    /**
     * 本地提交代码
     */
    @Test
    public void testCommit() throws IOException, GitAPIException,
            JGitInternalException {

        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider(USER_NAME, PASS_WORD);

        //git仓库地址
        try (Git git = Git.open(new File(localPath))) {
            git.pull().setRemoteBranchName("develop").
                    setCredentialsProvider(usernamePasswordCredentialsProvider).call();

            //提交代码
            git.commit().setMessage("test jGit").call();

            git.close();
        }

    }


    /**
     * 拉取远程仓库内容到本地
     */
    @Test
    public void testPull() throws IOException, GitAPIException {

        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider(USER_NAME, PASS_WORD);
        //git仓库地址
        try (Git git = Git.open(new File(localPath))) {
            git.pull().setRemoteBranchName("develop").
                    setCredentialsProvider(usernamePasswordCredentialsProvider).call();

            git.close();
        }
    }

    /**
     * push本地代码到远程仓库地址
     */
    @Test
    public void testPush() throws IOException, JGitInternalException,
            GitAPIException {

        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider(USER_NAME, PASS_WORD);
        //git仓库地址
        Git git = new Git(new FileRepository(localPath + "/.git"));
        git.push().setRemote("origin").setCredentialsProvider(usernamePasswordCredentialsProvider).call();
    }
}