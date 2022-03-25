package com.example.interview.jvm.string;


import org.testng.annotations.Test;

/**
 * @program: demo_
 * @description: 测试  intern()
 * @author: ZhaoYe
 * @create: 2021-08-02 20:53
 **/
public class StringIntern1 {

    public static void main(String[] args) {

        String s = new String("a") + new String("b");

        String s2 = s.intern();

        System.out.println(s == "ab");
        System.out.println(s2 == "ab");


    }

    @Test
    public void test2(){

        String s = new String("a") + new String("b");

        String s2 = s.intern();

        System.out.println(s == "ab");
        System.out.println(s2 == "ab");

    }
}