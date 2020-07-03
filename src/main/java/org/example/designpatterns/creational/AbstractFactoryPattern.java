package org.example.designpatterns.creational;

/**
 * @author minglan
 */
public class AbstractFactoryPattern {
    public static void test(){
        AbstractFactory factory = new FactoryProducer().getFactory("SHAPE");
        Shape shape = factory.getShape("Shape1");
        shape.draw();
    }
}

/**
 * 管理工厂，也就是工厂的工厂
 */
class FactoryProducer{
    public AbstractFactory getFactory(String name){
        if(name == "SHAPE"){
            return new ShapeFactory();
        }else if(name == "COLOR"){
            return new ColorFactory();
        }else{
            return null;
        }
    }
}

/**
 * 抽象工厂
 */
abstract class AbstractFactory{

    public abstract Shape getShape(String name);

    public abstract Color getColor(String name);

}

class ShapeFactory extends AbstractFactory{

    @Override
    public Shape getShape(String name) {
        if (name == "Shape1"){
            return new Shape1();
        }else if(name == "Shape2"){
            return new Shape2();
        }else {
            return null;
        }
    }

    @Override
    public Color getColor(String name) {
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    public Shape getShape(String name) {
        return null;
    }

    @Override
    public Color getColor(String name) {
        if(name == "Color1"){
            return new Color1();
        }else if(name == "Color2"){
            return new Color2();
        }else {
            return null;
        }
    }
}

interface Shape{
    void draw();
}

interface Color{
    void fill();
}

/** ================ 具体实现类 ======================*/
class Shape1 implements Shape{

    @Override
    public void draw() {
        System.out.println("creat Shape1");
    }
}

class Shape2 implements Shape{

    @Override
    public void draw() {
        System.out.println("creat Shape2");
    }
}

class Color1 implements Color{

    @Override
    public void fill() {
        System.out.println("creat Clor1");
    }
}

class Color2 implements Color{

    @Override
    public void fill() {
        System.out.println("create Color2");
    }
}