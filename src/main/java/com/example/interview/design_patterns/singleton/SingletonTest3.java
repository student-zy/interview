package design_patterns.singleton;

/**
 * @program: demo_
 * @description: 单例模式  懒汉式  多线程情况下不安全  实际开发中不推荐适用
 * @author: ZhaoYe
 * @create: 2021-11-02 13:07
 **/
public class SingletonTest3 {

    public static void main(String[] args) {
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance1 = Singleton3.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance.hashCode() = " + instance.hashCode());
    }

}

/***
 //懒汉式  线程不安全
 */

class Singleton3 {
    /***
     *  //1.构造器私有化
     */
    private Singleton3(){ }

    /****
     //2.本类内部创建实例对象
     */

    private  static Singleton3 instance ;

    /***
     //3.提供一个公有静态方法，当使用到改方法时候，才创建实例对象
     */
    public static Singleton3 getInstance(){
       if(instance==null){
           instance = new Singleton3();
       }
       return instance;
    }


}