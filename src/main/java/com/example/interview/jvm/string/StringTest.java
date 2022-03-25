package com.example.interview.jvm.string;

/**
 * @program: demo_
 * @description: String 的基本特性
 * @author: ZhaoYe
 * @create: 2021-08-02 14:06
 **/
public class StringTest {

    public static void main(String[] args) {

        //字面量的定义方式，“abc”存储在字符串的常量池中
        String s1 = "abc";
        String s2 = "abc";

        s1 = "hello";

        System.out.println(s1==s2);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        change(s1,s2);

    }

    private static void change(String s1, String s2) {
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}