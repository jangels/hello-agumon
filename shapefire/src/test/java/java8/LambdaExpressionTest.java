package java8;


import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Data
public class LambdaExpressionTest {

    static String str = "lzh";

    /**
     * base
     */
    @Test
    public void testLambda() {
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation addition2 = (a, b) -> a + b;
        // 大括号中的返回语句
        MathOperation addition3 = (a, b) -> {
            return a * b;
        };


        System.out.println(this.operate(1, 10, addition));
        System.out.println(this.operate(1, 10, addition2));
        System.out.println(this.operate(2, 10, addition3));


        // 不用括号
        System.out.println(this.operate1("hahaha", a -> {
            return a + "-------->ccc";
        }));
        // 用括号
        System.out.println(this.operate1("hahaha", (a) -> {
            return a + "-------->ccc";
        }));


        // 变量
        System.out.println(this.operate1(str, a -> {
            return "hello!" + str;
        }));

    }

    /**
     * 无参函数的简写
     */
    @Test
    public void testLambda1() {
        Thread thread1 = new Thread(() -> {
            System.out.println("new thread1...");
        });
        thread1.start();
    }

    /**
     * 带参函数的简写
     */
    @Test
    public void testLabmda3() {
        List<String> list = Arrays.asList("I", "love", "you", "too");
        Collections.sort(list, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        System.out.println(list);

        list.forEach(item -> {
            System.out.println(item + "...");
        });

        list.sort((a, b) -> {
            return b.length() - a.length();
        });

        list.forEach(item -> {
            System.out.println(item + "...");
        });
    }

    @Test
    public void testLambda4() {
        ConsumerInterface<String> ci = str -> {
            System.out.println(str);
        };
        ci.accept("hhh");

    }


    @Test
    public void testStream1() {
        Stream<String> stream = Stream.of("I", "love", "you", "too", "too");
        stream.distinct()
                .forEach(str -> System.out.println(str));
    }

    @Test
    public void testLambda5() {
        Map map = new HashMap();
        map.put("key1", "v1");
        map.put("key2", "v2");

        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }

    @Test
    public void testStream2() {
        int[] result = IntStream.of(10, 87, 97, 43, 121, 20, 43)
                .filter((e) -> e > 10)
                .map(e -> e * 2)
                .distinct()
                .sorted()
                .toArray();

        IntStream.of(result).forEach(e -> System.out.println(e));
    }

    // 自定义函数接口
    @FunctionalInterface
    public interface ConsumerInterface<T> {
        void accept(T t);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        String sayMessage(String message);
    }


    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    private String operate1(String a, GreetingService greetingService) {
        return greetingService.sayMessage(a);
    }
}
