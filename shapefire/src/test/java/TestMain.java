import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import lombok.Data;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class TestMain {

    static int num;


    public static void main(String[] args) {

        String userName = "userName 值";
        String cardNo = "cardNo 值";

        SecretKey secretKey = SecureUtil.generateKey("AES");
        byte[] encoded = secretKey.getEncoded();
        String secretKeyHex = HexUtil.encodeHexStr(encoded);
        System.out.println("密钥: " + secretKeyHex);

        byte[] keyRaw = HexUtil.decodeHex(secretKeyHex);
//        AES aes = SecureUtil.aes(keyRaw);
        AES aes = new AES(Mode.ECB, Padding.PKCS5Padding, "0CoJUm6Qyw8W8jud".getBytes());
        String encryptUserName = aes.encryptHex(userName);
        System.out.println("加密 userName 结果-->" + encryptUserName);
        String encryptCardNo = aes.encryptHex(cardNo);
        System.out.println("加密 cardNo 结果-->" + encryptCardNo);

        String s = aes.decryptStr(encryptCardNo);
        System.out.println("解密结果-->" + s);

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
