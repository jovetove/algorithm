package org.example.datastructure;

/**
 * @author minglan
 */
public class Node<T> {
    public T val;

    public Node(T val){
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
