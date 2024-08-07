package com.iebya.concurrent.namingthreadfactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamingThreadFactoryDemo {
    public static void main(String[] args) {
        NamingThreadFactory namingThreadFactory = new NamingThreadFactory("my-thread");
        for (int i = 1; i <= 10; i++) {
            // 提交任务给线程池
            namingThreadFactory.newThread(new Task(i)).start();
        }
    }
}
class NamingThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNum = new AtomicInteger();
    private final String name;

    /**
     * 创建一个带名字的线程池生产工厂
     */
    public NamingThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(name + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }
}
class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            // 模拟任务执行
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " taskId: " + taskId);
    }
}