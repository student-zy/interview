package com.example.interview.jvm.string;


import org.testng.annotations.Test;

/**
 * @program: demo_
 * @description: 常见面试题
 * @author: ZhaoYe
 * @create: 2021-08-02 15:47
 **/
public class StringDemo {

    @Test
    public void test1(){

        String s1 = "a" + "b" + "c";
        String s2 = "abc";

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }

    @Test
    public void test2(){
        String s1 = "javaee";
        String s2 = "hadoop";
        String s3 = "javaeehadoop";
        String s4 = "javaee" + "hadoop";
        //如果拼接符号的前后出现了变量，则相当于在堆空间中new String(),具体的内容为拼接的结果
        String s5 = s1 + "hadoop";
        String s6 = "javaee"+s2;
        String s7 = s1+s2;

        //intern()：判断字符串是否在存在该值，如果存在，则返回常量池中该值的地址，如果字符串常量池中不存在
        //则在常量池中加载一份该值，并返回对象地址
        String s8 = s6.intern();

        System.out.println(s3==s4);//true
        System.out.println(s3==s5);//false
        System.out.println(s3==s6);//false
        System.out.println(s3==s7);//false
        System.out.println(s5==s6);//false
        System.out.println(s5==s7);//true    正确的是false
        System.out.println(s6==s7);//true     正确的是false

        System.out.println(s3==s8);//true
    }

    @Test
    public void test3(){

        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1+s2;

        System.out.println(s3==s4);//false

    }
}