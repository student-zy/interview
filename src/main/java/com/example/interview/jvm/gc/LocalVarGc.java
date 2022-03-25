package com.example.interview.jvm.gc;

/**
 * @program: demo_
 * @description:  GC回收测试
 * @author: ZhaoYe
 * @create: 2021-08-26 09:42
 **/
public class LocalVarGc {

    public static void main(String[] args) {

        LocalVarGc localVarGc = new LocalVarGc();
        localVarGc.localvarGc2();
    }

    /**
     * 触发Minor GC没有回收对象，然后在触发Full GC将该对象存入old区
     */
    public void localvarGc1() {
        byte[] buffer = new byte[10*1024*1024];
        System.gc();
    }

    /**
     * 触发YoungGC的时候，已经被回收了
     */
    public void localvarGc2() {
        byte[] buffer = new byte[10*1024*1024];
        buffer = null;
        System.gc();
    }

    /**
     * 不会被回收，因为它还存放在局部变量表索引为1的槽中
     */
    public void localvarGc3() {
        {
            byte[] buffer = new byte[10*1024*1024];
        }
        System.gc();
    }

    /**
     * 会被回收，因为它还存放在局部变量表索引为1的槽中，但是后面定义的value把这个槽给替换了
     */
    public void localvarGc4() {
        {
            byte[] buffer = new byte[10*1024*1024];
        }
        int value = 10;
        System.gc();
    }

    /**
     * localvarGC5中的数组已经被回收
     */
    public void localvarGc5() {
        localvarGc1();
        System.gc();
    }


}