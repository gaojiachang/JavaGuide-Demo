package com.iebya.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 默认自然顺序，可以指定comparator
        queue.add(10);
        queue.add(20);
        queue.add(15);
        queue.add(5);
        queue.add(25);
        // 出队顺序
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
