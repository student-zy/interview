package com.example.interview.xunhun;

/**
 * @program: demo_
 * @description: 循环测试   while和for循环时间消耗差不多，基本没有太大差别
 * @author: ZhaoYe
 * @create: 2021-03-25 09:15
 **/
public class WhileAndFor {

    public static void main(String[] args) {
        forTest();
        whileTest();
    }

    private static void whileTest() {

        long l = System.currentTimeMillis();
        long a = 1L;
        while(a< 1000000000000L){
            a++;
        }
        System.out.println("while  a = " + a);
        long l1 = System.currentTimeMillis();
        long x = l1-l;
//        while   x = 280904
        System.out.println("while   x = " + x);

    }

    private static void forTest() {
        long l = System.currentTimeMillis();
        long b;
       for(b=1L; b< 1000000000000L; b++){

       }
        System.out.println("  for   b = " + b);
        long l1 = System.currentTimeMillis();
        long y = l1-l;
        //for    y = 279795
        System.out.println("for    y = " + y);

    }
}