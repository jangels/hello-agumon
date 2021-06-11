package prac;

public class TestString {

    public static void main(String[] args) {
//        test0();
//        test1();
        test2();
        test3();
    }

    public static void test0() {
        String s = null;
        s = s + "abc";
        System.out.println(s);
    }

    public static void test1() {
        String result = "hello" + "world";
        System.out.println(result);

        String result1 = "helloworld";
        System.out.println(result == result1);
    }

    public static void test2() {
        long start = System.currentTimeMillis();

        String str1 = "";
        for (int i = 0; i < 100000; i++) {
            str1 = str1 + ",java";
        }

        long end = System.currentTimeMillis();
        System.out.println("String + 用时:" + (end - start) + "ms");
    }

    public static void test3() {
        long start = System.currentTimeMillis();

        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < 10000000; i++) {
            sb1.append(",java");
        }

        long end = System.currentTimeMillis();
        System.out.println("StringBuilder用时:" + (end - start) + "ms");
    }
}
