package org.example.juc;

import java.util.concurrent.Callable;

public class CallableUse implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("程序开始运行");
        Thread.sleep(3000);
        System.out.println("程序运行结束");
        return 100;
    }
}


