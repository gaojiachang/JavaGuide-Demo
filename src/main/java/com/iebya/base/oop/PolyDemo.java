package com.iebya.base.oop;

public class PolyDemo {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.eat();
        a.sleep();
        // a.bark(); // 不能调用子类存在但父类不存在的方法
    }
}
class Animal {
    public void eat() {
        System.out.println("Animal eat");
    }
    public void sleep() {
        System.out.println("Animal sleep");
    }
}
class Dog extends Animal {
    public void eat() {
        System.out.println("Dog eat");
    }
    public void bark() {
        System.out.println("Dog bark");
    }
}