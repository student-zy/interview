package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: demo_
 * @description: 集齐7个龙珠，召唤神龙的Demo，我们需要首先创建CyclicBarrier
 * @author: ZhaoYe
 * @create: 2021-12-27 21:48
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        /*
         * 定义一个循环屏障，参数1：需要累加的值，参数2 需要执行的方法
         */
        CyclicBarrier cyclicBarrier =  new CyclicBarrier(7,() ->{
            System.out.println("召唤神龙");
        });

        int num = 7;
        for (int i = 1; i <= num; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到 第" + tempInt + "颗龙珠");

                try {
                    // 先到的被阻塞，等全部线程完成后，才能执行方法
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}