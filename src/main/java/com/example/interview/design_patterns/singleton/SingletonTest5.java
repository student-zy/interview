package design_patterns.singleton;

/**
 * @program: demo_
 * @description: 双重检查  懒汉式 线程安全
 * @author: ZhaoYe
 * @create: 2021-11-02 15:21
 **/
public class SingletonTest5 {

    public static void main(String[] args) {

        Singleton5 instance = Singleton5.getInstance();
        Singleton5 instance1 = Singleton5.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance.hashCode() = " + instance.hashCode());
    }
}

class Singleton5{

    private static volatile Singleton5 instance;
    
    private Singleton5(){}
    
    public static Singleton5 getInstance(){
        
        if(instance==null){
            synchronized (Singleton5.class){
                if(instance==null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}