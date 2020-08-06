import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.bouncycastle.jce.provider.JCEMac;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;

@Data
public class TestMain {

    static int num;


    public static void main(String[] args) {

        Annotation[] annotations = new TestMain().getClass().getDeclaredAnnotations();
        System.out.println(annotations);
        Arrays.stream(annotations)
                .forEach(item-> System.out.println(item.getClass()));

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
