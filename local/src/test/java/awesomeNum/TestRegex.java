package awesomeNum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String regex4 = "^520$";
        Pattern pattern = Pattern.compile(regex4);
        Matcher matcher = pattern.matcher("11520");
        System.out.println(matcher.matches());
    }
}
