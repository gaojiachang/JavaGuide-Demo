package com.iebya.concurrent.createthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) throws InterruptedException {
        // ExecutorService executorService = Executors.newFixedThreadPool(10); //创建固定大小的线程池
        ExecutorService executorService = Executors.newCachedThreadPool(); //动态大小
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
            // Thread.sleep(1);
        }
    }
}

class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Message = " + message);
        processMessage();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processMessage() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}