package org.example.designpatterns.creational;

/**
 * @author minglan
 */
public class SingletonPattern {
    public static void test(){

    }
}

/**
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
class Singleton1{
    private static Singleton1 singleton1;

    public Singleton1(){}

    public static Singleton1 getInstance(){
        return singleton1 == null ? new Singleton1() : singleton1;
    }
    public void doSomething(){
        System.out.println("懒汉式-线程不安全");
    }
}

/**
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 */
class Singleton2{
    private static Singleton2 singleton2;
    public Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        return singleton2 == null ? new Singleton2() : singleton2;
    }
    public void doSomething(){
        System.out.println("懒汉式-线程安全");
    }
}

/**
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * 它基于 classloader 机制避免了多线程的同步问题，
 * 不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法，
 * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
 */
class Singleton3{
    private static final Singleton3 singleton3 = new Singleton3();
    public Singleton3(){}
    public static Singleton3 getInstance(){
        return singleton3;
    }
    public void doSomething(){
        System.out.println("饿汉式-线程安全");
    }
}

/**
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 */
class Singleton4{
    private static volatile Singleton4 singleton4;
    public Singleton4(){}

    public static Singleton4 getInstance(){
        if(singleton4 == null){
            synchronized(Singleton4.class){
                singleton4 = singleton4 == null ? new Singleton4() : singleton4;
            }
        }
        return singleton4;
    }
    public void doSomething(){
        System.out.println("双检锁-线程安全");
    }
}

/**
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，
 * 应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 */
class Singleton5{
    private static class SingletonInner{
        private static final Singleton5 singleton5 = new Singleton5();
    }
    public Singleton5(){}

    public static Singleton5 getInstance(){
        return SingletonInner.singleton5;
    }
    public void doSomething(){
        System.out.println("双检锁-线程安全");
    }
}

/**
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 一个标准的enum单例模式，最优秀的写法还是实现接口的形式:
 */
interface SingletonInterface{
    void doSomething();
}
enum Singleton6 implements SingletonInterface{
    INSTANCE{
        @Override
        public void doSomething() {

        }
    };

    public static SingletonInterface getInstance(){
        return Singleton6.INSTANCE;
    }

}