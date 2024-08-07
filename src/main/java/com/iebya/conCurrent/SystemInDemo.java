package com.iebya.concurrent;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 事实证明，一个线程发生IO阻塞时，线程池中的其他线程正常执行
 */
public class SystemInDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new printTask());
        executorService.execute(new SystemInTask());
    }
}
class printTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; true; i++) {
            System.out.println("printTask: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class SystemInTask implements Runnable {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.println("SystemInTask: 结束");
        scanner.close();
    }
}