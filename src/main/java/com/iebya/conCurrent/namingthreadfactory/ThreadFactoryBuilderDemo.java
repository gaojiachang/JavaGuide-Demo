package com.iebya.concurrent.namingthreadfactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ThreadFactoryBuilderDemo {
    public static void main(String[] args) {
        String threadNamePrefix = "my-thread";
        // 创建一个阻塞队列，用于存放任务
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(100);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                                .setNameFormat(threadNamePrefix + "-%d")
                                .setDaemon(true).build();
       ExecutorService executorService = new ThreadPoolExecutor(2, 4, 1, TimeUnit.MINUTES,workQueue,threadFactory);
           
            for (int i = 1; i <= 10; i++) {
                // 提交任务给线程池
                executorService.submit(new Task(i));
            }
    
            // 关闭线程池
            executorService.shutdown();
    
            try {
                // 等待所有任务完成
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
    
            System.out.println("All tasks completed");
    }
}