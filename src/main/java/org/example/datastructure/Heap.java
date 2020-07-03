package org.example.datastructure;

import java.util.Comparator;

/**
 * 堆是完全二叉树
 * 索引为 i 的节点，左右节点为2i+1 和 2i+2
 * 索引为 j 的节点的父节点为 (j-1)/2
 * @author minglan
 */
public class Heap {
    final int DEFAULT_INITIAL_CAPACITY = 11;
    protected Object[] heap;
    /**外部比较器*/
    protected Comparator<Object> comparator;
    /** 表示当前元素的数量**/
    protected int size;

    public Heap(){
        heap = new Object[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    public Heap(int capacity){
        heap = new Object[capacity];
        size = 0;
    }

    public Heap(int capacity, Comparator<Object> comp){
        heap = new Object[capacity];
        comparator = comp;
        size = 0;
    }

    public void add(Integer element){
        // 先自增了 1
        if(++size == heap.length){
            Object[] newHeap = new Object[2*heap.length];
            // 浅拷贝 复制对象的引用
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
        heap[size -1] = element;
        percolateUP();
    }

    public Object getMin(){
        return size == 0 ? null : heap[0];
    }

    public Object removeMin(){
        if(size == 0) {
            return null;
        }
        Object minElem = heap[0];
        heap[0] = heap[size-1];
        // size 先减 1 ，并把 mindElem 放在了 size 位置 -> 堆排序
        heap[--size] = minElem;
        percolateDown(0);
        return minElem;

    }

    private void percolateUP(){
        // 获取最后一个插入元素的下标
        int child = size -1;
        int  parent;
        while (child > 0){
            parent = (child-1)/2;
            if(compare(heap[parent], heap[child]) <= 0){
                break;
            }
            swap(heap, child, parent);
            child = parent;
        }
    }

    private void percolateDown(int start){
        int parent = start;
        int child = 2*parent+1;
        Object temp;
        while (child < size){
            if(child < size-1 && compare(heap[child], heap[child+1]) >0){
                child++;
            }
            if(compare(heap[parent], heap[child]) <= 0){
                break;
            }
            swap(heap, child, parent);
            child = 2*parent +1;
        }
    }

    private int compare(Object o1, Object o2){
        if(comparator == null){
            return ((Comparable)o1).compareTo(o2);
        }else{
            return comparator.compare(o1,o2);
        }
    }

    private void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
