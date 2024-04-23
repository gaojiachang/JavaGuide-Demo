package com.iebya.conCurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileAtomicityDemo {
    public static void myRun() throws InterruptedException {
        VolatileAtomicity volatileAtomicity = new VolatileAtomicity();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++){
            threadPool.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileAtomicity.increase();
                }
            });
        }
        
        Thread.sleep(1000); // 等待所有线程执行完毕
        System.out.println(volatileAtomicity.cnt);
        threadPool.shutdown(); // 关闭线程池
    }
}

class VolatileAtomicity {
    volatile int cnt = 0; // volatile保证可见性，但不保证原子性

    public void increase(){ // 想要保证原子性，可以在方法上加synchronized关键字
        cnt++;
    }
}
