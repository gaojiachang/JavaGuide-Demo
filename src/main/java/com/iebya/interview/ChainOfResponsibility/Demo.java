package com.iebya.interview.ChainOfResponsibility;

public class Demo {
    public static void main(String[] args) {
        Handler a = new A(), b = new B();
        a.setNext(b);
        a.process(5);  // A处理
        a.process(15); // B处理
    }
}
abstract class Handler {
    Handler next;
    void setNext(Handler next) { this.next = next; }
    abstract void process(int num);
}

class A extends Handler {
    void process(int num) {
        if (num < 10) System.out.println("A处理");
        else if (next != null) next.process(num);
    }
}

class B extends Handler {
    void process(int num) {
        if (num < 20) System.out.println("B处理");
        else if (next != null) next.process(num);
    }
}
