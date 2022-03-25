package design_patterns.singleton;

/**
 * @program: demo_
 * @description: 懒汉式  线程安全
 * @author: ZhaoYe
 * @create: 2021-11-02 15:13
 **/
public class SingletonTest4 {

    public static void main(String[] args) {

        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance1 = Singleton4.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance.hashCode() = " + instance.hashCode());

    }
}

/***
 //懒汉式  线程安全
 */

class Singleton4 {
    /***
     *  //1.构造器私有化
     */
    private Singleton4(){ }

    /****
     //2.本类内部创建实例对象
     */

    private  static Singleton4 instance ;

    /***加入锁synchronized   不推荐  效率太低
     //3.提供一个公有静态方法，当使用到改方法时候，才创建实例对象
     */
    public static synchronized Singleton4 getInstance(){
        if(instance==null){
            instance = new Singleton4();
        }
        return instance;
    }


}