package org.example;
import org.example.designpatterns.creational.AbstractFactoryPattern;
import org.example.designpatterns.creational.FactoryPattern;
import org.example.juc.PAbyBlockingQueue;
import org.example.juc.PAbyCondition;
import org.example.juc.PAbySemaphore;
import org.example.juc.PAbySynchronize;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AbstractFactoryPattern.test();
    }

    /**
     * 最大的第K个元素
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int index = partition(nums, 0, nums.length-1);
        while(true){
            if(index == k){
                return nums[k];
            }else if(index < k){
                index = partition(nums,index+1,nums.length-1);
            }else{
                index = partition(nums,0, index-1);
            }
        }
    }

    public static int partition(int[] nums, int l, int r){
        int index = nums[l];
        while(l < r){
            while(l < r && nums[r] <= index){
                r--;
            }
            nums[l] = nums[r];
            while(l < r && nums[l] >= index){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = index;
        return l;
    }
    public static void swap(int[] nums, int i, int j){
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }


    public static int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int first = 0;
        int last = 0;
        int sum = 0;
        while(last < nums.length && first < nums.length){
            sum += nums[first];
            while(sum >= s){
                minLen = Math.min(minLen, first - last+1);
                sum -= last;
                last++;
            }
            first++;
        }
        return minLen == Integer.MAX_VALUE ? 0:minLen;

    }

    public static int sum(int[] nums, int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}


