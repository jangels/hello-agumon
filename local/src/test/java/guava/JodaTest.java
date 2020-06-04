package guava;

import lombok.Data;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Joda-time 日期工具类
 * <p>
 * Created by lzh on 2019/2/18.
 */
@Data
public class JodaTest {
    public final static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testTime() {

        // 当前时间
        DateTime dt = new DateTime();
        System.out.println(dt.minusDays(1).toString(PATTERN));
        System.out.println(dt.getYear());

        // 指定时间
        DateTime dt2 = new DateTime(2018, 12, 14, 1, 1, 1);
        System.out.println(dt2.toString(PATTERN));
    }

    @Test
    public void testSocialHandle() {

        String dataString = "1550275367682\n" +
                "1550280789680\n" +
                "1550280978462\n" +
                "1550284563034\n" +
                "1550284765375\n" +
                "1550285199063\n" +
                "1550287081851\n" +
                "1550289245536\n" +
                "1550295996748\n" +
                "1550305602851\n" +
                "1550307153628\n" +
                "1550321912325\n" +
                "1550367116904\n" +
                "1550371160685\n" +
                "1550399347172\n" +
                "1550399535210\n" +
                "1550400328242\n" +
                "1550400601545\n" +
                "1550400629061";

        String[] dataStringArr = dataString.split("\n");
        for(int i = 0 ; i < dataStringArr.length;i++){
            DateTime dt3 = new DateTime(Long.valueOf(dataStringArr[i]));
            System.out.println(dt3.toString(PATTERN));
        }

    }
}
