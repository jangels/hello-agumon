package prac;

import java.util.HashMap;
import java.util.Map;

public class TestFinally {
    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(test1());
    }

    public static int test() {
        int i = 1 ;
        try {
            return i;
        } catch (Exception e) {

        } finally {
            i = 10;
        }
        return i;
    }

    public static Map test1(){

        Map<String, Integer> map  = new HashMap<>();
        try {
            map.put("key",1) ;
            return map;
        } catch (Exception e) {

        } finally {
            map.put("key",10) ;
        }
        return map;
    }
}
