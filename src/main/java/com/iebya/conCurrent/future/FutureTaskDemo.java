package com.iebya.concurrent.future;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Task is running");
                return "hello world!";
            }
        };
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        FutureTask<String> futureTask = new FutureTask<>(callable);
        executorService.submit(futureTask);
        try {
            String result = futureTask.get();
            System.out.println("Task result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
