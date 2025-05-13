package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DeepTestLamda {
    public static void main(String[] args) throws Exception {
        A a = i -> {
            System.out.println("hello : " + i);
        };
        a.m(1);

        // i > o
        Function<Integer, String> function = i -> {
            System.out.println("hello : " + i);
            return "world";
        };
        System.out.println(function.apply(1));

        // i
        Supplier<String> supplier = () -> {
            System.out.println("hello");
            return "world";
        };
        System.out.println(supplier.get());
        // o
        Consumer<String> consumer = s -> {
            System.out.println("hello : " + s);
        };
        consumer.accept("world");

        // test
        Predicate<String> predicate = s -> s.length() > 0;
        System.out.println(predicate.test("hello"));
    }

    @FunctionalInterface
    interface A {
        void m(int i);
    }
}
