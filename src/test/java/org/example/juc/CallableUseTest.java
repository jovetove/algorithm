package org.example.juc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static org.junit.Assert.*;

public class CallableUseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test() throws ExecutionException, InterruptedException {
        CallableUse callableUse = new CallableUse();
        FutureTask<Integer> task = new FutureTask<>(callableUse);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("执行其他任务3");
        System.out.println("执行其他任务3");
        Thread.sleep(2);
        System.out.println(task.get());
        System.out.println("执行其他任务3");
    }
}