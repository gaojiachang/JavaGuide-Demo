package com.iebya.conCurrent;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThread {
    public static void myRun() throws ExecutionException, InterruptedException {
//        方法1：通过继承Thread类
//        MyThread myThread1 = new MyThread(1);
//        MyThread myThread2 = new MyThread(2);
//        myThread1.start();
//        myThread2.start();

//        方法2：通过实现Runnable接口
//        MyRunnable myRunnable1 = new MyRunnable(1);
//        MyRunnable myRunnable2 = new MyRunnable(2);
//        Thread runnableThread1 = new Thread(myRunnable1);
//        Thread runnableThread2 = new Thread(myRunnable2);
//        runnableThread1.start();
//        runnableThread2.start();

//        方法3：通过实现Callable接口。优势：可以获取返回值
//        ExecutorService executorService = Executors.newFixedThreadPool(2); //创建大小为2的固定线程池
//        Future<List<Integer>> future1 = executorService.submit(new myCallable(5));
//        Future<List<Integer>> future2 = executorService.submit(new myCallable(10));
//        System.out.println(future1.get());
//        System.out.println(future2.get());

//        输出当前所有线程
//        for(Thread t:Thread.getAllStackTraces().keySet())
//            System.out.println(t.getName());

        System.out.println("This is myRun.");
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
class MyRunnable implements Runnable{
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
