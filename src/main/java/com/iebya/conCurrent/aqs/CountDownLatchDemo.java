package com.iebya.concurrent.aqs;
import java.util.concurrent.*;

public class CountDownLatchDemo {
    // 处理文件的数量
    private static final int threadCount = 6;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（推荐使用构造方法创建）
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println("threadnum:" + threadnum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //表示一个文件已经被完成
                    countDownLatch.countDown();
                }

            });
        }
        System.out.println("wait all child thread over!");
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }
}
