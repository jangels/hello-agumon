package awesomeNum;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        Map map = new TreeMap((o1, o2) -> (Integer) o1 - (Integer) o2);

        Map awesomeNum = new TreeMap((o1, o2) -> (Integer) o1 - (Integer) o2);

        for (int i = 0; i < 30000; i++) {
            String ran = RandomStringUtils.randomNumeric(8);
            Integer intValue = Integer.valueOf(ran);
            if (isAwesomeNo(ran)) {
                awesomeNum.put(intValue, i);
            } else {
                map.put(intValue, i);
            }
        }
        System.out.println("-----------");
        System.out.println(map.size());
//        System.out.println(map);
        System.out.println("靓号数量" + awesomeNum.size());
        System.out.println("靓号:" + awesomeNum);
    }

    /**
     * 是否是靓号
     *
     * @param num
     * @return
     */
    private static boolean isAwesomeNo(String num) {
//        // .匹配5位顺增或顺降
//        String regex1 = "^(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){4}" +
//                "|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){4})\\d$";
//
//
//        // 匹配4-9位连续的数字
//        String regex2 = "^(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){3,}" +
//                "|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){3,})\\d$";
//
//        // 匹配3位以上的重复数字
//        String regex3 = "^([\\d])\\1{2,}$";
//
//        //
//        String regex4 = "(\\d)\\1(\\d)\\2$";
//
//        String regex5 = "^$";
//
//        String regex6 = "^$";


        List<String> levitPatterns = new ArrayList<>();
        // 手机号、生日号、跟公司业务相关的号码
//        levitPatterns.add("^(0|13|15|18|168|400|800)[0-9]*$");
        levitPatterns.add("^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$");
        levitPatterns.add("^\\d*(1688|2688|2088|2008|5188|10010|10001|666|888|668|686|688|866|868|886|999)\\d*$");
        // 重复号码，镜子号码
//        levitPatterns.add("^(<a>\\d)(\\d)(\\d)\\1\\2\\3$");
//        levitPatterns.add("^(\\d)(\\d)(\\d)\\3\\2\\1$");
        // AABB
//        levitPatterns.add("^\\d*(\\d)\\1(\\d)\\2\\d*$");
        // AAABBB
//        levitPatterns.add("^\\d*(\\d)\\1\\1(\\d)\\2\\2\\d*$");
        // ABABAB
//        levitPatterns.add("^(\\d)(\\d)\\1\\2\\1\\2\\1\\2$");
        // ABCABC
//        levitPatterns.add("^(\\d)(\\d)(\\d)\\1\\2\\3$");
        // ABBABB
//        levitPatterns.add("^(\\d)(\\d)\\2\\1\\2\\2$");
        // AABAAB
//        levitPatterns.add("^(\\d)\\1(\\d)\\1\\1\\2$");

        // 4-8 位置重复
//        levitPatterns.add("^\\d*(\\d)\\1{2,}\\d*$");
        // 4位以上 位递增或者递减（7890也是递增）
//        levitPatterns.add("(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)|9(?=0)){2,}|(?:0(?=9)|9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){2,})\\d");

        // 不能以 518 、918 结尾
//        levitPatterns.add("^[0-9]*(518|918)$");

        for (String item : levitPatterns) {
            Pattern pattern = Pattern.compile(item);
            Matcher matcher = pattern.matcher(num);
            if (matcher.matches()) {
                System.out.println("匹配到值:" + num);
                return true;
            }
        }
        return false;
    }
}
