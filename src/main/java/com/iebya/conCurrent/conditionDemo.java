package com.iebya.concurrent;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// condition接口可以做到选择性通知，也就是通知几个线程，而不是synchronized要么通知一个要么通知所有线程
public class conditionDemo {
    private static final int CAPACITY = 10;
    private final LinkedList<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            lock.lock();
            try {
                while (queue.size() == CAPACITY) {
                    bufferNotFull.await(); // 释放锁并阻塞当前线程；直到①被唤醒②重新获取锁，才能继续执行
                }
                queue.add(value);
                System.out.println("Producer produced: " + value);
                value++;
                // 通知所有等待的消费者队列现在非空
                bufferNotEmpty.signalAll();
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    bufferNotEmpty.await();
                }
                int value = queue.removeFirst();
                System.out.println(Thread.currentThread().getName() + " consumed: " + value);
                // 通知生产者队列未满
                bufferNotFull.signal();
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        conditionDemo pcm = new conditionDemo();
        Thread producer = new Thread(() -> {
            try {
                pcm.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();

        // 创建多个消费者线程
        for (int i = 0; i < 3; i++) {
            Thread consumer = new Thread(() -> {
                try {
                    pcm.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Consumer-" + i);
            consumer.start();
        }
    }
}
