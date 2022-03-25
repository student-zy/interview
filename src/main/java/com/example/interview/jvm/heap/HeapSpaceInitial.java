package com.example.interview.jvm.heap;

/**
 * @program: demo_
 * @description: 堆空间默认大小测试
 * @author: ZhaoYe
 * @create: 2021-04-14 14:41
 **/
public class HeapSpaceInitial {

    public static void main(String[] args) {
        //返回JVM堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() /1024/1024;
        //返回JVM堆内存试图使用最大的堆内存总量
        long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;
        System.out.println("initialMemory = " + initialMemory+"m");
        System.out.println("maxMemory = " + maxMemory+"m");


    }


}