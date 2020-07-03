package org.example.designpatterns.creational;

import java.awt.*;

/**
 * 使用类
 *
 * @author minglan
 */
public class FactoryPattern {
    public static void test(){
        CarFactory carFactory = new CarFactory();
        Tool tool = carFactory.getCar("Car1");
        tool.creat();
    }
}

class CarFactory{
    public Tool getCar(String name){
        if(name == null){
            return null;
        }
        switch (name){
            case "Car1":
                return new Car1();
            case "Car2":
                return new Car2();
            case "Car3":
                return new Car3();
            default:
                return null;
        }
    }
}

interface Tool{
    void creat();
}


class Car1 implements Tool{

    @Override
    public void creat() {
        System.out.println("创建Car1");
    }
}

class Car2 implements Tool{

    @Override
    public void creat() {
        System.out.println("创建Car2");
    }
}

class Car3 implements Tool{

    @Override
    public void creat() {
        System.out.println("创建Car3");
    }
}