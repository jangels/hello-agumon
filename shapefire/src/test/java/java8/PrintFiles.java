package java8;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintFiles {

    public static void main(String[] args) throws IOException {

        Files.walkFileTree(Paths.get("/Users/lzh/lzh/shell"), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // 文件md5
                String filePath = file.toString();
                String md5 = DigestUtils.md5Hex(new FileInputStream(filePath));
                System.out.println(filePath + ">>>" + md5);
                return FileVisitResult.CONTINUE; // 没找到继续找
            }

        });
    }
}
