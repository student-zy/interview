package com.example.interview.jvm.string;

/**
 * @program: demo_
 * @description: new String()
 * @author: ZhaoYe
 * @create: 2021-08-02 19:21
 *
 *
 * 题目;new String("ab") 一共创建几个对象？  看字节码知道是两个对象
 *      一个对象是:new 关键字在堆空间创造的
 *      一个对象是：字符串常量池中的对象。字节码指令：ldc
 *
 *    思考：new String("a") + new String("b") 一共创建了几个对象？
 *    对象①new StringBuilder()
 *    对象②new String()
 *    对象③字符串常量池中的对象"a" 字节码指令：ldc
 *    对象④new String()
 *    对象⑤字符串常量池中的对象"b" 字节码指令：ldc
 *
 *    深入剖析：new StringBuilder中的toString()方法会new String()
 *    对象⑥：new String("ab")  强调一下，toString()的调用，在字符串常量池中，没有生成"ab"
 *
 **/
public class StringNewTest {
    public static void main(String[] args) {

        //String str = new String("ab");
        String str = new String("a")+new String("b");
    }
}