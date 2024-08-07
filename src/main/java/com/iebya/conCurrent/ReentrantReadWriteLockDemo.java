package com.iebya.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private int value = 0;

    public void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " got write lock");
            value++;
            // 休眠一下来模拟写操作
            Thread.sleep(1000);
            // 在持有写锁的同时获取读锁
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " got read lock while holding write lock");
                // 模拟读取操作
                System.out.println("Current Value: " + value);
            } finally {
                readLock.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released write lock");
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        Thread writerThread = new Thread(demo::write, "WriterThread");
        writerThread.start();
    }
}
