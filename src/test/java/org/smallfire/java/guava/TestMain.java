package org.smallfire.java.guava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;

public class TestMain {

    public static final String FORMAT = "yyyyMMdd";

    public static void main(String[] args) throws ParseException {
//        for (int i = 0; i < 200; i++) {
//            System.out.println(i+" 的ascii为：" + (char) i);
//        }
        Runnable r = () -> System.out.println("hello lambda!");
        r.run();

        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("he!");


        // 打印某一年,每一个日期能被7整除的日期, 格式 20200207


        Calendar cal = Calendar.getInstance();
        String firstDay = "20210101";

        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        Date firstDayDate = sdf.parse(firstDay);

        cal.setTime(firstDayDate);


        for (int i = 1; i < 366; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);

            int day = cal.get(Calendar.DAY_OF_MONTH);
            if (day % 7 == 0) {

                System.out.println(sdf.format(cal.getTime()));
            }
        }
    }
}
