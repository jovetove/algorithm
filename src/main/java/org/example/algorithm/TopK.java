package org.example.algorithm;

/**
 * @author minglan
 */
public class TopK {
    /**
     * 找到数组中第k大的数
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k){
        int kk = findKthLargest(nums, k-1, 0, nums.length-1);
        return nums[kk];
    }

    public static int findKthLargest(int[] nums, int k, int low, int high){
        int index = partition(nums, low, high);
        if(index == k){
            return index;
        }else if(index < k){
            return findKthLargest(nums, k, index+1, high);
        }else {
            return findKthLargest(nums, k, low, index-1);
        }
    }

    public static int partition(int[] nums, int low, int high){
        int index = nums[low];
        while (low < high){
            while (low < high && nums[high] <= index){
                high --;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] >= index){
                low ++;
            }
            nums[high] = nums[low];
        }
        nums[low] = index;
        return low;
    }
}



