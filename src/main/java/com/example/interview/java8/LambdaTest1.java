package com.example.interview.java8;


import org.testng.annotations.Test;

/**
 * @program: interview
 * @description: java8新特性
 * @author: ZhaoYe
 * @create: 2022-01-31 11:50
 **/
public class LambdaTest1 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈哈-------------");
            }
        };
        runnable.run();

        System.out.println("=====================================");
        Runnable runnable1 = ()->{
            System.out.println("---------lambda----------------");
        };
        runnable1.run();
    }


}