package org.example.algorithm;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

/**
 * @author minglan
 */
public class InsertArray {
    public int[] arr;

    public InsertArray(int[] nums){
        this.arr = nums;
    }

    public void insertToIndex(int index, int key){
        int[] newArray = new int[arr.length + 1];
        // 朝第index个后面插入,所以复制前index个数字去
        System.arraycopy(arr, 0, newArray,0, index);
        System.arraycopy(arr, index, newArray, index+1, arr.length - index);
        newArray[index] = key;
        arr = newArray;
    }

    @Override
    public String toString() {
        return "InsertArray{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
