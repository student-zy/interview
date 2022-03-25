package design_patterns.singleton;

/**
 * @program: demo_
 * @description: 测试 饿汉式  静态代码块
 * @author: ZhaoYe
 * @create: 2021-11-02 12:56
 **/
public class SingletonTest2 {

    public static void main(String[] args) {


        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());

    }
}

/***
 //饿汉式  静态代码块
 */

class Singleton2 {
    /***
     *  //1.构造器私有化
     */
    private Singleton2(){

    }


    /****
     //2.本类内部创建实例对象
     */
    private  static Singleton2 instance ;

    /*
     * 在静态代码块中创建单例对象
     */
    static {
        instance = new Singleton2();
    }
    /***
     //3.提供一个公有静态方法，返回实例对象
     */
    public static Singleton2 getInstance(){
        return instance;
    }


}