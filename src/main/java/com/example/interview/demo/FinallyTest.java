package com.example.interview.demo;

import org.testng.annotations.Test;

/**
 * @program: interview
 * @Author: zy_zhao
 * @Date: 2022-02-23
 */
public class FinallyTest {

    public static void main(String[] args) {
        int i = myMethod();
        System.out.println("i = " + i);
    }


    public static int  myMethod() {

        try {
            System.out.println("try 代码块被执行！");
            int a = 1/0;
            return 0;
        } catch (Exception e) {
            System.out.println("catch 代码块被执行！");
            return 1;
        } finally {
            System.out.println("finally 代码块被执行！");
            return 2;
        }

    }

}