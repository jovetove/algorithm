package org.example.algorithm;


public class kth_smallest_element_in_a_sorted_matrix {

    /**
     * 378. 有序矩阵中第K小的元素
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        //left是最小值，right是最大值
        int left = matrix[0][0];
        int right = matrix[len-1][len-1];

        //二分查找
        while(right > left){
            int mid = left + (right - left) / 2;

            //checkLessThanK(matrix, mid, k) 表示：小于等于mid的值 的 数量 小于k
            /*
                想象一下，mid = 7， k = 5
                说明matrix中小于等于7的值只有（0-4）个，
                举个例子：
                    matrix中有{1 2 7 7 8 9}
                    小于等于7的有{1， 2， 7， 7}
                    第5大的数字，肯定就是从8开始找咯
                那我们要找的是第k小的数字，这个数字肯定要比mid大吧，从mid+1开始找吧
                否则，就从小于等于mid的这个部分来找吧
            */
            if(checkLessThanK(matrix, mid, k)){
                left = mid+1;
            }
            else{
                //小于等于mid的值 的 数量 大于等于k
                right = mid;
            }
        }
        return left;
    }

    /**
     *     小于等于mid的数量少于K
     */

    public static Boolean checkLessThanK(int[][] matrix, int mid, int k){
        int num = 0;
        int j = 0;
        // row
        int i = matrix.length -1;

        // 小于等于 -> 右
        // 大于 -> 上
        //这个计数的方法很特别哦，不是一行一行加的。是一列一列加的！
        while(i >= 0 && j < matrix.length){
            if(matrix[i][j] <= mid) {
                j++;
                num += i+1;
            }
            else{
                i--;
            }
            if(num >= k)    return false;
        }
        return true;
    }

    /**
     * 剑指 Offer 04. 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        String s=
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
