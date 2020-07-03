package org.example.algorithm.dp;

/**
 * 01背包问题
 */
public class BackpackOfZoreOne {
    public BackpackOfZoreOne(){

    }
    /**
     * 一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
     * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，
     * 现在让你用这个背包装物品，最多能装的价值是多少？
     * @param W 背包的最大可装重量
     * @param weigth 物品重量
     * @param value 物品对应价值
     * @return 可以装的最大价值
     */
    public static int getMaxValue(int W, int[] weigth, int[] value){
        if(weigth.length != value.length){
            return -1;
        }
        int N = weigth.length;
        // dp[i][w] 表示：对于前 i 个物品，当前背包的容量为 w 时，这种情况下可以装下的最大价值
        // 由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
        int[][] dp = new int[N+1][W+1];

        for(int i = 1; i < N+1; i++){
            for (int j = 1; j < W+1; j++){
                // 如果物品大于背包容量\
                // 由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(j < weigth[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else { // 选择不装入当前物品，或者装入
                    // 不装入就等于上一个物品的价值
                    // 装入  等于 找出 W-物品重量时的最大价值 + 当前价值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weigth[i-1]] + value[i-1]);
                }
            }
        }
        int j = W;
        String numStr = "";
        // 若 dp[i][j] > dp[i-1][j],这说明第i件物品是放入背包的
        for(int i = N; i>0; i--){
            if(dp[i][j]>dp[i-1][j]){
                numStr = i + " " + numStr;
                j = j - weigth[i-1];
            }
            if(j == 0){
                break;
            }
        }
        System.out.println("装入包的物品编号为："+numStr);
        // 返回最大价值
        return dp[N][W];
    }

    /**
     * 0-1背包的优化解法
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     * @param W 背包的最大可装重量
     * @param weigth 物品重量
     * @param value 物品对应价值
     * @return 可以装的最大价值
     */
    public static int getMaxValue2(int W, int[] weigth, int[] value){
        if(weigth.length != value.length){
            return -1;
        }
        int N = weigth.length;
        int[] dp = new int[W+1];
        for(int i = 1; i<N+1; i++){
            // 唯一需要注意的是 j 应该从后往前反向遍历，因为每个物品（或者说数字）只能用一次，以免之前的结果影响其他的结果。
            //只有当j >= w[i],dp[j]才能进行选取最大值,否则dp[j]将不作更新，等于dp[i-1][j]。
            for(int j = W; j >=weigth[i-1]; j--){
                dp[j] = Math.max(dp[j-weigth[i-1]] + value[i-1],dp[j-1]);
            }
        }
        return dp[W];
    }

}
