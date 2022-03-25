package com.example.interview.java8.lambda;



/**
 *
 * @author zhaoye
 * @date 2018/7/5
 */
@FunctionalInterface
public interface Myfun<T,R> {

    public R getValue(T t1, T t2);



}
