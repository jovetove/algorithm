package org.example.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现生产者消费者
 * @author minglan
 */
public class PAbyCondition {
    public PAbyCondition(){

    }
    public static void start(){
        DepotByCondition depot = new DepotByCondition(0,10);
        new ProducerByConditions(depot).produce(500);
        new ProducerByConditions(depot).produce(200);
        new ConsumerByCondition(depot).consume(500);
        new ConsumerByCondition(depot).consume(200);
    }

}

class ConsumerByCondition{
    private final DepotByCondition depot;
    public ConsumerByCondition(DepotByCondition depot){
        this.depot = depot;
    }
    public void consume(int num){
        new Thread(()->{depot.consumer(num);}).start();
    }
}

class ProducerByConditions{
    private final DepotByCondition depot;
    public ProducerByConditions(DepotByCondition depot){
        this.depot = depot;
    }

    public void produce(int num){
        new Thread(()->{depot.produce(num);}).start();
    }
}

class DepotByCondition{
    private int size;
    private final int capacity;
    private final Lock lock;
    private final Condition fullCondition;
    private final Condition emptyCondition;

    public  DepotByCondition(int size, int capacity){
        this.size = size;
        this.capacity = capacity;
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void produce(int num){
        lock.lock();
        try{
            while(num > 0){
                while (size >= capacity){
                    System.out.println("货架已满，等待中...");
                    fullCondition.await();
                    System.out.println("货架，等待后...");
                }
                // 增量
                int incr = capacity - size < num ? capacity - size : num;
                size += incr;
                num -= incr;
                System.out.println("生产者生产 "+ incr + " 当前容量为： " + size+"/"+capacity);
                Thread.sleep(1000);
                emptyCondition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void consumer(int num){
        lock.lock();
        try {
            while (num > 0){
                while (size == 0){
                    System.out.println("货架为空，等待生产者生产");
                    emptyCondition.await();
                    System.out.println("货架为空，等待生产者生成之后");
                }
                int sub = size - num >= 0 ? num : size;
                num -= sub;
                size -= sub;
                System.out.println("消费者消费 " + sub + " 当前容量为： " + size + "/" + capacity);
                Thread.sleep(1000);
                fullCondition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}