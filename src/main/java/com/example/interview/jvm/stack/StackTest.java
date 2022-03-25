package com.example.interview.jvm.stack;

/**
 * @program: demo_
 * @description: test
 * @author: ZhaoYe
 * @create: 2021-03-24 10:28
 **/
public class StackTest {

    public static void main(String[] args) {

        StackTest stackTest = new StackTest();
        stackTest.methodA();

    }

    public  void methodA(){
        int a = 10;
        int b = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        methodB();
    }
    public  void methodB(){
        int c = 30;
        int d = 40;
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}