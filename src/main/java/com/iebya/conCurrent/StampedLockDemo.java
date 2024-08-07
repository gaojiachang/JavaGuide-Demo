package com.iebya.concurrent;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    private final StampedLock stampedLock = new StampedLock();
    private double x, y;  // 示例中的共享资源

    // 写操作：移动点的位置
    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();  // 获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);  // 释放写锁
        }
    }

    // 读操作：计算到原点的距离
    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();  // 尝试获取一个乐观读锁
        double currentX = x, currentY = y;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();  // 获取一个悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);  // 释放读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    public static void main(String[] args) {
        StampedLockDemo demo = new StampedLockDemo();

        // 更新点的位置
        demo.move(5, 5);

        // 读取点的位置并计算距离
        System.out.println("Distance from origin: " + demo.distanceFromOrigin());
    }
}
