package com.iebya.concurrent.thread;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class createThreadDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//     方法1：继承Thread类
       Thread myThread1 = new MyThread(1);
       Thread myThread2 = new MyThread(2);
       myThread1.start();
       myThread2.start();
//    方法2：new一个Thread，传入Runnable任务
        Thread runnableThread3 = new Thread(new TaskR(3));
        Thread runnableThread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 4 run!");
            }
        });
        runnableThread3.start();
        runnableThread4.start();
// 方法3：new一个Thread，传入FutureTask任务，FutureTask是对Callable的封装
        FutureTask<List<Integer>> futureTask = new FutureTask<>(new myCallable(10));
        Thread threadC5 = new Thread(futureTask);
        threadC5.start();
        System.out.println(futureTask.get());
// 方法4：new一个Thread，重写run方法
        Thread thread6 = new Thread(){
            @Override
            public void run(){
                System.out.println("Thread 6 run!");
            }
        };
        thread6.start();
    }
}
@AllArgsConstructor
class MyThread extends Thread{
    Integer threadId;
    public void run(){
        System.out.println("Thread " + threadId + " run!");
    }
}
@AllArgsConstructor
class TaskR implements Runnable{
    Integer threadId;
    public void run(){
        System.out.println("Thread " + threadId + " run!");
    }
}

@AllArgsConstructor
class myCallable implements Callable<List<Integer>>{
    Integer val;
    public List<Integer> call(){
        List ret = new ArrayList<>();
        for (Integer i = 0;i < val;i++) ret.add(i);
        return ret;
    }
}
