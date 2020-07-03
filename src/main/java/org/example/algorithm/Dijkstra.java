package org.example.algorithm;

import java.lang.reflect.Array;

/**
 * @author minglan
 */
public class Dijkstra {
    public final static int MAX_NUM = Integer.MAX_VALUE;
    public static int[][] martic = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},

            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    public static void dijstra(int[][] martix, int bengin, int end){
        // 存储到每个点的最短路径，找到比原来更短的则直接覆盖
        int len = martix.length;
        int[] paths = new int[len];
        // 默认为false
//        boolean[] isVisited = new boolean[len];
        System.arraycopy(martix[bengin],0, paths, 0, martix.length);

        for(int i = 0; i <len; i++){
        }


    }
}
