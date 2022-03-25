package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo_
 * @description: Exchanger 测试
 * @author: ZhaoYe
 * @create: 2022-01-12 10:58
 **/
public class ExchangerTest {

    private static final  Exchanger<String> stringExchanger = new Exchanger<>();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String str1 = "book11";
                    String exchange = stringExchanger.exchange(str1);
                    System.out.println("exchange:"+exchange);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    String str2 = "book22";
                    String str1 = stringExchanger.exchange(str2,10, TimeUnit.SECONDS);
                    System.out.println("str1和str2录入的是否一致："+str1.equals(str2)
                            +",str1录入的是:"+str1+",str2录入的是:"+str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}