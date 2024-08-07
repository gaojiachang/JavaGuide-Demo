package com.iebya.concurrent;
import lombok.AllArgsConstructor;

public class ProducerConsumer {
    public static void myRun(){
        SharedResource sharedResource = new SharedResource();
        Thread threadProducer = new Thread(new Producer(sharedResource));
        Thread threadConsumer = new Thread(new Consumer(sharedResource));
        threadConsumer.start();
        threadProducer.start();
        System.out.println("This is myRun!");
    }
}
class SharedResource{
    private Integer count = 0;
    private Integer max = 10;
    public synchronized void take() throws InterruptedException {
        while(count.equals(0)){
            wait();
        }
        count--;
        System.out.println("拿取一个资源后，资源数：" + count);
        notifyAll();
    }
    public synchronized void put() throws InterruptedException {
        while(count.equals(max)){
            wait();
        }
        count++;
        System.out.println("放入一个资源后，资源数：" + count);
        notifyAll();
    }
}
@AllArgsConstructor
class Producer implements Runnable{
    SharedResource resource;
    public void run(){
        while (true) {
            try {
                resource.put();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
@AllArgsConstructor
class Consumer implements Runnable{
    SharedResource resource;
    public void run(){
        while(true){
            try {
                resource.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}