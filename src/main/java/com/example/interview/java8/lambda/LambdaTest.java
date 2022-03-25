package com.example.interview.java8.lambda;



import org.testng.annotations.Test;

import java.util.Comparator;

/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，
 *             格式： ClassName::MethodName
 *
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * 1. 类名 :: new
 *
 * 三、数组引用
 *
 * 	类型[] :: new;
 */

/**
 *
 * @author zhaoye
 * @date 2018/7/5
 */
public class LambdaTest {


    @Test
    public void test1() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };
        runnable.run();

        System.out.println("------------------------------");

        Runnable r = () -> System.out.println("hello lambda!");
        r.run();

    }

    @Test
    public void test2(){

        Comparator<Integer> com = (x,y) -> {
            System.out.println("多条语句");
            return Integer.compare(x,y);
        };

    }

    @Test
    public void test3(){
        op(100L,20L, Long::sum);
        op(100L,20L,(x,y)->x*y);

    }

    /**
     * 对两个Long类型的数据进行处理
     * @param l1
     * @param l2
     * @param mf
     */
    public void  op(Long l1,Long l2,Myfun<Long,Long> mf){

        System.out.println(mf.getValue(l1,l2));
    }

    @Test
    public void test4(){


        Comparator<Integer> com = Integer::compare;
        int compare = com.compare(23, 34);

        Comparator<Integer> cop = Integer::compare;
        int compare1 = cop.compare(23, 12);

        System.out.println(compare);
        System.out.println(compare1);
    }
}
