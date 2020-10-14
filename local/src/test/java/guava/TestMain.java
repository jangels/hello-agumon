package guava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Consumer;

public class TestMain {

    public static final String FORMAT = "yyyyMMdd";

    public static final HashMap map = new HashMap(200);

    public static void main(String[] args) throws ParseException, InterruptedException {

       print007Date("2020");
    }

    public static void print007Date(String firstDay) throws ParseException {
        // 打印某一年,每一个日期能被7整除的日期, 格式 20200207
        Calendar cal = Calendar.getInstance();

        firstDay = firstDay + "0101";

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
