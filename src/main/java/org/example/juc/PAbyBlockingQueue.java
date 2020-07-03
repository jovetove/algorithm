package org.example.juc;

import java.util.concurrent.ArrayBlockingQueue;


/**
 * @author minglan
 */
public class PAbyBlockingQueue {
    public static void start(){
        DepotByBlockingQueue depotByBlockingQueue = new DepotByBlockingQueue(0,10);
        new ProducerByBlockQueue(depotByBlockingQueue).produce(500);
        new ConsumerByBlockQueue(depotByBlockingQueue).consumer(500);
        new ConsumerByBlockQueue(depotByBlockingQueue).consumer(500);
    }
}

class ProducerByBlockQueue{
    private final DepotByBlockingQueue depotByBlockingQueue;
    public ProducerByBlockQueue(DepotByBlockingQueue depotByBlockingQueue){
        this.depotByBlockingQueue = depotByBlockingQueue;
    }
    public void produce(int num){
        new Thread(()->{
            try {
                depotByBlockingQueue.producer(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ConsumerByBlockQueue{
    private final DepotByBlockingQueue depotByBlockingQueue;

    public ConsumerByBlockQueue(DepotByBlockingQueue depotByBlockingQueue){
        this.depotByBlockingQueue = depotByBlockingQueue;
    }

    public void consumer(int num){
        new Thread(()->{
                    try {
                        depotByBlockingQueue.consumer(num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
    }
}

class DepotByBlockingQueue{
    private final int size;
    private final int capacity;
    private final ArrayBlockingQueue queue;

    public DepotByBlockingQueue(int size, int capacity){
        this.size = size;
        this.capacity = capacity;
        queue = new ArrayBlockingQueue(capacity);
    }

    public void consumer(int num) throws InterruptedException {
        while (num>0){
            queue.take();
            num --;
            System.out.println(Thread.currentThread().getId() + " - 还需要消费: " + num +"货架剩余："+ queue.toString());
            Thread.sleep(500);
        }
    }

    public void producer(int num) throws InterruptedException {
        while (num>0){
            queue.put(1);

            num --;
            System.out.println(Thread.currentThread().getId() + " - 还需要生产: " + num +"货架剩余："+ queue.toString());
            Thread.sleep(400);
        }
    }
}