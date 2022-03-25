package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.*;

/**
 * @program: demo_
 * @description: 手写线程池
 * @author: ZhaoYe
 * @create: 2021-12-29 09:42
 **/
public class MyThreadPoolExecutorDemo {
    public static void main(String[] args) {

        //创建了一个 核心线程数为2，最大线程数为5，并且阻塞队列数为3的线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
        try {

            // 循环十次，模拟业务办理，让5个线程处理这10个请求
            int x = 10;
            for (int i = 1; i <= x; i++) {
                final int tempInt = i;
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}