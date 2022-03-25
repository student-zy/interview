package com.example.interview.jvm.loader;

/**
 * @program: demo_
 * @description: loader test
 * @author: ZhaoYe
 * @create: 2021-03-22 16:26
 **/
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> aClass = Class.forName("java.lang.String");
        ClassLoader classLoader = aClass.getClassLoader();

        System.out.println("classLoader = " + classLoader);


        System.out.println("=========================");

        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);
        ClassLoader parent = classLoader1.getParent();
        System.out.println("parent = " + parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println("parent1 = " + parent1);


    }
}