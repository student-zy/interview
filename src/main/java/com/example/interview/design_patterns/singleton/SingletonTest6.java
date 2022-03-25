package design_patterns.singleton;

/**
 * @program: demo_
 * @description: 单例模式   静态内部类 推荐使用 避免了线程不安全,利用静态内部类特点实现延迟加载,效率高
 * @author: ZhaoYe
 * @create: 2021-11-02 17:32
 **/
public class SingletonTest6 {

    public static void main(String[] args) {

        Singleton6 instance = Singleton6.getInstance();
        Singleton6 instance1 = Singleton6.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance.hashCode() = " + instance.hashCode());
    }
}

class Singleton6{

    //private static volatile Singleton6 instance;

    private Singleton6(){}

    private static class SingletonInstance{
        private static final Singleton6 INSTANCE = new Singleton6();
    }
    public static Singleton6 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}