package com.example.interview.jvm.string;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @program: demo_
 * @description: intern()方法的理解
 * @author: ZhaoYe
 * @create: 2021-08-02 19:41
 *
 *
 **/
public class StringIntern
{
    public static void main(String[] args) {

        String s = new String("a");
        //调用此方法之前字符串常量池已经存在“a”
        s.intern();
        String s1 = "a";
        //jdk6/7/8  false
        System.out.println(s==s1);

        System.out.println("======================================");
        //s2记录的地址为：new String("12")
        String s2 = new String("1")+ new String("2");
        //执行完上行代码后，字符串常量池中存在“12”吗？不存在
        //在字符串常量池中生成“12”
        s2.intern();
        String s3 = "12";

        //jdk6 :false    jdk7/8 : true
        System.out.println(s2==s3);


    }


    @Test
    public void test1(){

        String s = new String("a");
        s.intern();
        String s1 = "a";
        System.out.println(s==s1);

        System.out.println("======================================");
        String s2 = new String("1")+new String("2");

        s2.intern();
        String s3 = "12";

        System.out.println(s2 == s3);

    }


    @Test
    public void testIntern(){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}