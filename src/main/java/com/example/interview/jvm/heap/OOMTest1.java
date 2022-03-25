package com.example.interview.jvm.heap;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @program: demo_
 * @description: 方法区OOM
 * @author: ZhaoYe
 * @create: 2021-07-27 15:02
 *
 *  * jdk6/7中：
 *  * -XX:PermSize=10m -XX:MaxPermSize=10m
 *  *
 *  * jdk8中：
 *  * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 **/
public class OOMTest1 extends ClassLoader{

    public static void main(String[] args) {
        int j = 0;
        try {
            OOMTest1 test = new OOMTest1();
            int num = 10000;
            for (int i = 0; i < num; i++) {
                //创建ClassWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                //类的加载  Class对象
                test.defineClass("Class" + i, code, 0, code.length);
                j++;
            }
        } finally {
            System.out.println(j);
        }
    }

}