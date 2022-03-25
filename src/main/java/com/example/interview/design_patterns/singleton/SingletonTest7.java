package design_patterns.singleton;

/**
 * @program: demo_
 * @description: 单例模式   枚举
 * @author: ZhaoYe
 * @create: 2021-11-02 17:43
 **/
public class SingletonTest7 {

    public static void main(String[] args) {

        Singleton7 instance = Singleton7.INSTANCE;
        Singleton7 instance2 = Singleton7.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());
        instance.say();
        instance2.say();
    }
}

/***
 1.枚举不仅能避免多线程同步问题,而且还能防止反序列化重新创建新的对象
 2. 这种方式也是Effective Java的作者提倡的方式
 推荐使用
*/

enum Singleton7{
    /**
     * 属性
     */
    INSTANCE;
    public void say(){
        System.out.println("hi~~~~~");
    }
}