package com.iebya.base.method;

/**
 * OverrideDemo
 */
public class OverrideDemo {
    public static void main(String[] args) {
        Parent p = new Child();
        p.staticMethod(); // 输出 "Parent static method"
        
        Child.staticMethod(); // 输出 "Child static method"
    }
}
class Parent {
    private void privateMethod() {
        System.out.println("Parent private method");
    }
    
    final void finalMethod() {
        System.out.println("Parent final method");
    }
    
    static void staticMethod() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    // 这会导致编译错误，因为无法重写父类的 private 方法
    // private void privateMethod() {
    //     System.out.println("Child private method");
    // }

    // 这会导致编译错误，因为无法重写父类的 final 方法
    // @Override
    // void finalMethod() {
    //     System.out.println("Child final method");
    // }

    // 这不是重写，而是方法隐藏
    static void staticMethod() {
        System.out.println("Child static method");
    }
}