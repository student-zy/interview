package com.example.interview.spring1.Circulardepend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: demo_
 * @description: 循环依赖测试
 * @author: zy_zhao
 * @create: 2022-01-12 15:25
 **/
public class CircularDependTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CirculardependA a = context.getBean("a", CirculardependA.class);
        CirculardependB b = context.getBean("b", CirculardependB.class);
    }
}