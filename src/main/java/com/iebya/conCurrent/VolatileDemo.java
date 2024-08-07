package com.iebya.concurrent;

public class VolatileDemo {
    private static volatile boolean running = true; // volatile修饰符，保证了可见性，如果不加volatile，子线程终止较晚甚至永远不会终止
    // private static boolean running = true;

    public static void myRun() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (running) {
                // 模拟工作
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(1000);  // 休眠一秒钟，模拟工作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread is stopped.");
        });

        thread.start();
        Thread.sleep(3000); // 主线程休眠3秒钟，让子线程运行
        
        running = false; // 设置running为false，让子线程停止
        System.out.println("Flag updated to false. Thread should stop now.");
    }
}
