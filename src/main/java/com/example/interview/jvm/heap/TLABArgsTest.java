package com.example.interview.jvm.heap;

/**
 * @program: demo_
 * @description: 测试-XX:UseTLAB参数是否开启的情况 默认是开启的
 * @author: ZhaoYe
 * @create: 2021-07-25 23:02
 **/
public class TLABArgsTest {

    public static void main(String[] args) {
        System.out.println("哈哈哈哈哈哈哈哈哈");
        try{
            Thread.sleep(100000);
        }catch(InterruptedException  e){
            e.printStackTrace();
        }

    }
}