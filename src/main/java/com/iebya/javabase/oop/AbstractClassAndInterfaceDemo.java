package com.iebya.javabase.oop;

public class AbstractClassAndInterfaceDemo {
    public static void main(String[] args) {
        Animala a = new Doga();
        a.makeSound();
        a.sleep();
        System.out.println(a.age); // 10
        a.getAge(); //如果子类实现getAge，输出20，否则输出10
        Animali ai = new Dogi();
        ai.makeSound();
        ai.sleep();
        System.out.println(ai.age); // 10
        ai.getAge(); //如果子类实现getAge，输出20，否则输出10
        
    }
}
// 抽象类 Animal
abstract class Animala {
    int age = 10; // 默认为default
    // 抽象方法 makeSound()
    public abstract void makeSound();

    // 普通方法 sleep()
    public void sleep() {
        System.out.println("Zzz...");
    }
    public void getAge() {
        System.out.println(age);
    }
}

// 具体类 Dog 继承自抽象类 Animal
class Doga extends Animala {
    int age = 20;
    // 实现抽象方法 makeSound()
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
    @Override
    public void getAge() {
        System.out.println(age);
    }
}

interface Animali {
    int age = 10; // 默认为public static final
    void makeSound(); //默认为abstract
    default void sleep(){ // default method
        System.out.println("Zzz... interface");
    }
    void getAge();
}
class Dogi implements Animali {
    int age = 20; // 无效，因为接口中的变量默认为public static final
    @Override
    public void makeSound() {
        System.out.println("Woof! interface");
    }
    @Override
    public void getAge() {
        System.out.println(age);
    }
}