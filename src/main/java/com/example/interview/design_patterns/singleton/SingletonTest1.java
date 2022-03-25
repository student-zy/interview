package design_patterns.singleton;

/**
 * @program: demo_
 * @description: 测试  饿汉式   缺点 ：浪费内存
 * @author: ZhaoYe
 * @create: 2021-11-02 12:48
 **/
public class SingletonTest1 {

    public static void main(String[] args) {

        Singleton1 singleton = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();

        System.out.println(singleton2==singleton);

        System.out.println("singleton.hashCode() = " + singleton.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());


    }
}


/***
 //饿汉式  静态变量
*/

 class Singleton1 {
    /***
     *  //1.构造器私有化
     */
    private Singleton1(){

    }

    /****
     //2.本类内部创建实例对象
     */

    private final static Singleton1 INSTANCE  =  new Singleton1();

    /***
     //3.提供一个公有静态方法，返回实例对象
     */
    public static Singleton1 getInstance(){
        return INSTANCE;
    }


}