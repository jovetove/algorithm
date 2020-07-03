package org.example.juc;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * @author minglan
 */
public class PAbySemaphore {
    public static void start(){
        DepotBySemaphore depot = new DepotBySemaphore(10);
        new ProducerBySemphore(depot).produce(500);
        new ConsumerBySemphore(depot).consume(500);
    }
}

class ProducerBySemphore{
    private final DepotBySemaphore depotBySemaphore;

    public ProducerBySemphore(DepotBySemaphore depotBySemaphore){
        this.depotBySemaphore = depotBySemaphore;
    }
    public void produce(int num){
        new Thread(()->{depotBySemaphore.produce(num);}).start();
    }
}

class ConsumerBySemphore{
    private final DepotBySemaphore depotBySemaphore;

    public ConsumerBySemphore(DepotBySemaphore depotBySemaphore){
        this.depotBySemaphore = depotBySemaphore;
    }
    public void consume(int num){
        new Thread(()->{depotBySemaphore.consume(num);}).start();
    }
}

class DepotBySemaphore{
    private final Semaphore metx = new Semaphore(1);
    private final Semaphore notEmpty = new Semaphore(0);
    private final Semaphore notFull;
    private final ArrayList<Integer> list;

    public DepotBySemaphore(int capacity){
        this.notFull = new Semaphore(capacity);
        this.list = new ArrayList<>(capacity);
    }

    public void produce(int num) {
        while (num > 0){
            try{
                // 保证非满
                notFull.acquire();
                metx.acquire();

                num --;
                list.add(1);
                System.out.println("生产,当前容量 " + list.toString() + " 还需生产 " + num);
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                metx.release();
                // 增加非空
                notEmpty.release();
            }
        }
    }

    public void consume(int num){
        while (num > 0){
            try{
                // 非空需要早与互斥锁
                notEmpty.acquire();
                metx.acquire();
                num--;
                list.remove(list.size()-1);
                System.out.println("消费,当前容量 " + list.toString() + " 还需消费 " + num);
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                metx.release();
                notFull.release();
            }
        }
    }
}