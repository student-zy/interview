package com.example.interview.shangguigu_zhouyang.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: demo_
 * @description: 一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 * @author: ZhaoYe
 * @create: 2021-12-29 15:48
 *
 *  * 生产者消费者  阻塞队列版
 *  * 使用：volatile、CAS、atomicInteger、BlockQueue、线程交互、原子引用
 **/
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) throws Exception{

        // 传入具体的实现类， ArrayBlockingQueue
        MyResource2 myResource = new MyResource2(new ArrayBlockingQueue<String>(10));
       //生产线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println("");
            System.out.println("");
            try {
                myResource.myProd();
                System.out.println("");
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        //消费线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");

            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        // 5秒后，停止生产和消费
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("");
        System.out.println("5秒中后，生产和消费线程停止，线程结束");
        myResource.stop();
    }
}

/*
资源类
*/
class MyResource2{
    // 默认开启，进行生产消费
    // 这里用到了volatile是为了保持数据的可见性，也就是当FLAG修改时，要马上通知其它线程进行修改
    private volatile boolean FLAG = true;
    // 使用原子包装类，而不用number++
    private AtomicInteger atomicInteger = new AtomicInteger();

    // 这里不需要具体实例化一个类,定义接口，后面需要什么再去实例化类
    BlockingQueue<String> blockingQueue = null;

    // 而应该采用依赖注入里面的，构造注入方法传入
    public MyResource2(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        // 查询出传入的class是什么
        System.out.println(blockingQueue.getClass().getName());
    }

    /**
     * 生产
     * @throws Exception
     */
    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        // 多线程环境的判断，一定要使用while进行，防止出现虚假唤醒
        // 当FLAG为true的时候，开始生产
        while(FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            // 2秒存入1个data
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "成功" );
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "失败" );
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "\t 停止生产，表示FLAG=false，生产结束");
    }

    /**
     * 消费
     */
    public void myConsumer() throws Exception{
        String retValue;
        // 多线程环境的判断，一定要使用while进行，防止出现虚假唤醒
        // 当FLAG为true的时候，开始生产
        while(FLAG) {
            // 2秒存入1个data
            retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(retValue == null || "".equalsIgnoreCase(retValue)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒钟没有取到数值，消费退出");
                return;
            }

            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+retValue+"成功");
        }
    }

    /**
     * 停止生产的判断
     */
    public void stop() throws Exception{
        this.FLAG = false;
    }

}