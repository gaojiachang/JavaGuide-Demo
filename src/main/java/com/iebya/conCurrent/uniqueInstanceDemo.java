package com.iebya.conCurrent;

public class uniqueInstanceDemo {
    public static void myRun() {
        Singleton singleton = Singleton.getUniqueInstance();
        System.out.println(singleton);
    }
}

class Singleton {
    private static Singleton uniqueInstance;
    
    private Singleton() {}

    public static Singleton getUniqueInstance(){
        if (uniqueInstance == null) { //第一次检验，保证类被实例化后不会再次实例化。
            //第二次检验，保证不会多个线程同时进入实例化代码块（因为有可能多个线程在检验uniqueInstance时都为空），依次防止每个线程实例化一个对象。
            synchronized(Singleton.class){
                if (uniqueInstance == null) { 
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
