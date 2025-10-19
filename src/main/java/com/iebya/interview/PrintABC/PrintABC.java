package com.iebya.interview.PrintABC;

public class PrintABC {
    static int state = 0;
    static final Object lock = new Object();
    
    public static void main(String[] args) {
        new Thread(() -> print("A", 0, 1)).start();
        new Thread(() -> print("B", 1, 2)).start();
        new Thread(() -> print("C", 2, 0)).start();
    }
    
    static void print(String s, int current, int next) {
        for (int i = 0; i<=10 ; i++) {
            synchronized (lock) {
                while (state != current) {
                    try { lock.wait(); } catch (Exception e) { }
                }
                System.out.print(s);
                state = next;
                lock.notifyAll();
            }
        }
    }
}