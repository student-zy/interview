package com.example.interview.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo_
 * @description: GC测试
 * @author: ZhaoYe
 * @create: 2021-07-25 17:07
 * 测试MinorGC、MajorGC、FullGC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 **/
public class GCTest {

    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "atguigu.com";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }

        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("遍历次数为：" + i);
        }
    }

}