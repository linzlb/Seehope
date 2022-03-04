package com.linzlb.javaguide.synsingleton;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/18 14:30
 * @Function:双重校验锁实现对象单例（线程安全）
 */
public class Singleton {

    /*
    uniqueInstance 采用 volatile 关键字修饰也是很有必要的，
    uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
    为 uniqueInstance 分配内存空间
    初始化 uniqueInstance
    将 uniqueInstance 指向分配的内存地址
    但是由于jvm具有指令重排的特性，执行顺序有可能变成 1->3->2。
    指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。
    例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，
    因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
    使用 volatile 可以禁止jvm的指令重排，保证在多线程环境下也能正常运行。
     */
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public  static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
