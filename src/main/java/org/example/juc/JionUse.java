package org.example.juc;

/**
 * join() 使用
 * 在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
 */
public class JionUse {

    static class A extends Thread{

        @Override
        public void run() {
            System.out.println("A");
        }
    }

    static class B extends Thread{
        private final A a;

        public B(A a){
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public static void useJoin(){
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
//        a.start();
    }

}

