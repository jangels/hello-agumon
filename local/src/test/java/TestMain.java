import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.bouncycastle.jce.provider.JCEMac;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.IntStream;

@Data
public class TestMain {

    static int num;


    public static void main(String[] args) {


        String property = System.getProperty("file.encoding");
        System.out.println(property);
        System.out.println(1_0000);

        String userName = "userName 值"; String cardNo = "cardNo 值";
        String key = "78a0e4f3980117f135217cf3b3f0970d";


        SecretKey secretKey = SecureUtil.generateKey("AES");
        System.out.println("密钥" + new String(secretKey.getEncoded()));


        AES aes = SecureUtil.aes(key.getBytes());
        String encryptUserName = aes.encryptHex(userName); System.out.println("加密 userName 结果-->" + encryptUserName);
        String encryptCardNo = aes.encryptHex(cardNo); System.out.println("加密 cardNo 结果-->" + encryptCardNo);


     /*   Annotation[] annotations = new TestMain().getClass().getDeclaredAnnotations();
        System.out.println(annotations);
        Arrays.stream(annotations)
                .forEach(item-> System.out.println(item.getClass()));
*/
       /* String oldStr = "lzh";
        String lzh = DigestUtils.sha1Hex(oldStr);
        System.out.println(lzh);

        String s = DigestUtils.sha256Hex(oldStr);
        System.out.println(s);*/

        /*
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                num++;
            }).start();

            System.out.println("num ==" + num);

            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        }

         */
    }
}

 class StreamParallelDemo {
    public static void main(String[] args) {
        System.out.println(String.format("本计算机的核数：%d", Runtime.getRuntime().availableProcessors()));

        // 产生100w个随机数(1 ~ 100)，组成列表
        Random random = new Random();

        int count = 1_0000_0000;
        List<Integer> list = new ArrayList<>(count);


        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(100));
        }

        System.out.println(list.size());

        long prevTime = getCurrentTime();
        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("单线程计算耗时：%d", getCurrentTime() - prevTime));

        prevTime = getCurrentTime();
        list.stream().parallel().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("多线程计算耗时：%d", getCurrentTime() - prevTime));

    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
