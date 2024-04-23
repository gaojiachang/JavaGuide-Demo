package com.iebya.conCurrent;

public class staticSynchronizedDemo {
    public static void myRun(){
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<3; i++){
                    staticSynchronized.increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<3; i++){
                    staticSynchronized.increment();
                }
            }
        });
        Thread t3 = new Thread(){
            public void run(){
                staticSynchronized s = new staticSynchronized();
                s.printCount();
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
class staticSynchronized{
    private static int count = 0;
    public static synchronized void increment(){
        count++;
    }
    public void printCount(){
        System.out.println(count);
    }
}
