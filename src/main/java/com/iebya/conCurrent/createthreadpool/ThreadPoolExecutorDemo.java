package com.iebya.concurrent.createthreadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // 创建一个阻塞队列，用于存放任务
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        // 创建一个线程池，核心线程数为2，最大线程数为4，线程空闲时间为60秒
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,                       // 核心线程数
            4,                       // 最大线程数
            60,                      // 空闲线程等待时间
            TimeUnit.SECONDS,        // 时间单位
            workQueue                // 工作队列
        );

        for (int i = 1; i <= 10; i++) {
            // 提交任务给线程池
            executor.submit(new Task(i));
        }

        // 关闭线程池
        executor.shutdown();

        try {
            // 等待所有任务完成
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks completed");
    }
}

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " starting");
        try {
            // 模拟任务执行
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task " + taskId + " completed");
    }
}
