package org.example.algorithm;

/**
 * 实现循环数组的插入和扩容
 * @author minglan
 */
public class CircularArray {
    private final Object[] arr;
    private final int tair;
    private int head;
    private int currentSize;

    public CircularArray(int len){
        arr = new Object[len];
        tair = 0;
        head = 0;
        currentSize = 0;
    }

    public void addFirst(Object element){
        if(element == null){
            return;
        }
        currentSize ++;
        head = (currentSize + head) % arr.length;
        arr[head] = element;
        if(head == tair){
            resize();// 扩容
        }
    }

    public void addLast(Object element){

    }

    public Object removeLast(){
        return new Object();
    }

    public Object removenFirst(){
        return new Object();
    }

    public void resize(){

    }
}
