package org.smallfire.java.guava;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Joda-time 日期工具类
 *
 * Created by lzh on 2019/2/18.
 */
public class JodaTest {
    public final static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testTime() {

        // 当前时间
        DateTime dt = new DateTime();
        System.out.println(dt.minusDays(1).toString(PATTERN));

        // 指定时间
        DateTime dt2 = new DateTime(2018, 12, 14, 1, 1, 1);
        System.out.println(dt2.toString(PATTERN));
    }
}
