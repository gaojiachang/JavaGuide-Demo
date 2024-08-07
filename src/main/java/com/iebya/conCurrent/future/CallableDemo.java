package com.iebya.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Future<Integer> future = executorService.submit(new Task());
        try {
            Integer result = future.get();
            System.out.println("Task result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Task is running");
        return 1;
    }
}
