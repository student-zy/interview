package com.example.interview.jvm.gc;

import java.util.ArrayList;

/**
 * @program: demo_
 * @description: -XX:+PrintCommandLineFlags：查看命令行相关参数（包含使用的垃圾收集器）
 *                   使用命令行指令：jinfo -flag  相关垃圾回收器参数  进程ID
 * @author: ZhaoYe
 * @create: 2021-08-27 15:48
 **/
public class GcUseTest {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        while (true){
           byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}