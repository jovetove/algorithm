package org.example.juc;

import javax.crypto.spec.DESedeKeySpec;

public class PAbySynchronize {
    public static void start(){
        DepotBySynchronized depot = new DepotBySynchronized(0,10);
        ConsumerBySynchronized consumer1 = new ConsumerBySynchronized(depot);
        ProduceBySynchronized produce = new ProduceBySynchronized(depot);
        consumer1.consumer(500);
        produce.porduce(499);
    }
}

class ConsumerBySynchronized{
    private final DepotBySynchronized depotBySynchronized;

    public ConsumerBySynchronized(DepotBySynchronized depotBySynchronized){
        this.depotBySynchronized = depotBySynchronized;
    }
    public void consumer(int num){
        new Thread(()->{
            try {
                depotBySynchronized.consumer(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ProduceBySynchronized{
    private final DepotBySynchronized depotBySynchronized;
    public ProduceBySynchronized(DepotBySynchronized depotBySynchronized){
        this.depotBySynchronized = depotBySynchronized;
    }
    public void porduce(int num){
        new Thread(()->{
            try {
                depotBySynchronized.produce(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class DepotBySynchronized{
    private int size;
    private final int capacity;

    public DepotBySynchronized(int size,int capacity){
        this.size = size;
        this.capacity = capacity;
    }


    public synchronized void produce(int num) throws InterruptedException {
        try{
            while (num > 0){
                while (size >= capacity){
                    System.out.println("货架已满，等待中...");
                    this.wait();
                }
                int incr = capacity - size - num >= 0 ? num : capacity -size;
                size += incr;
                num -= incr;
                System.out.println("加入 " + incr+ " 当前size " + size);
                this.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void consumer(int num) throws InterruptedException {
        try{
            while (num > 0){
                while (size == 0){
                    System.out.println("货架为空，等待生产者生产...");
                    this.wait();
                }
                int sub = num >= size ? size : num;
                size -= sub;
                num -= sub;
                System.out.println("消费 "+ sub);
                this.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

