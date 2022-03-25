package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo_
 * @description: 验证volatile的可见性
 * @author: ZhaoYe
 * @create: 2021-12-24 12:42
 *   假设int number = 0， number变量之前没有添加volatile关键字修饰 就没有可见性
 **/

public class VolatileDemo {

    public static void main(String[] args) {

        testVolatileVisibility();

        testVolatileAtomicity();



    }

    /**
     * 验证volatile不保证原子性
     */
    private static void testVolatileAtomicity() {
        MyData myData = new MyData();

        // 创建10个线程，线程里面进行1000次循环
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while(Thread.activeCount() > 2) {
            // yield表示不执行
            Thread.yield();
        }

        // 查看最终的值
        // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
    }

    /***
     *验证volatile的可见性
    */

    private static void testVolatileVisibility() {
        // 资源类
        MyData myData = new MyData();

        // AAA线程 实现了Runnable接口的，lambda表达式
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t come in");

            // 线程睡眠3秒，假设在进行运算
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改number的值
            myData.addTo60();

            // 输出修改后的值
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);

        }, "AAA").start();

        // main线程就一直在这里等待循环，直到number的值不等于零
        while(myData.number == 0) {}
        System.out.println("------------------------------");
        // 按道理这个值是不可能打印出来的，因为主线程运行的时候，number的值为0，所以一直在循环
        // 如果能输出这句话，说明AAA线程在睡眠3秒后，更新的number的值，重新写入到主内存，并被main线程感知到了
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
/**
 * 假设是主物理内存
 */
class MyData {

    volatile int number = 0;
//    int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number ++;
    }
}

