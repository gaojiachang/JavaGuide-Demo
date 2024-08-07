package com.iebya.concurrent;

public class uniqueInstanceDemo {
    public static void myRun() {
        Singleton singleton = Singleton.getUniqueInstance();
        System.out.println(singleton);
    }
}

// 双重校验锁实现单例模式
class Singleton {
    private static volatile Singleton uniqueInstance;
    
    private Singleton() {}

    public static Singleton getUniqueInstance(){
        if (uniqueInstance == null) { //第一次检验，保证类被实例化后不会再次实例化。
            // 给类对象加锁，防止多个进程通过第一次检查时，都执行实例化代码。
            synchronized(Singleton.class){
                // 第二次检验，防止每一线程拿到锁后，都会实例化一个对象。
                if (uniqueInstance == null) { 
                    uniqueInstance = new Singleton(); //代码分三步执行：1.分配内存 2.初始化对象 3.将对象指向分配的内存
                }
            }
        }
        return uniqueInstance;
    }
}
