package com.iebya.interview.Print100;

public class Print100 {
    static int num = 1;
    static final Object lock = new Object();
    
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (num <= 100) {
                    synchronized (lock) {
                        if (num <= 100) {
                            System.out.println(Thread.currentThread().getName() + ": " + num++);
                        }
                    }
                    try { Thread.sleep(100); } catch (Exception e) {}
                }
            }).start();
        }
    }
}
