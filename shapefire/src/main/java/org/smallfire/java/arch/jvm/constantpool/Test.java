package org.smallfire.java.arch.jvm.constantpool;

public class Test {
    public static void main(String[] args) {
        String s1 = new String("lzh")+" ";

        System.out.println(s1 == s1.intern());


         String str3 = "计算机技术";
         String str2=new StringBuilder("计算机").append("技术").toString();
         System.out.println(str2==str2.intern());//true
    }
}
