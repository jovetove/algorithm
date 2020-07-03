package org.example.algorithm.dp;

/**
 * 完全背包问题
 * @author minglan
 */
public class BackpackOfCompletely {
    public static int getNum(int amount, int[] coins){
        int len = coins.length;
        // 若只使用前 i 个物品，当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包。
        int[][] dp = new int[len+1][amount+1];

        // dp[0][j] = 0 如果不使用任何硬币面值，就无法凑出任何金额；
        for (int j = 0; j < amount+1; j++) {
            dp[0][j] = 0;
        }
        // dp[i][0] = 1; 如果凑出的目标金额为 0，那么“无为而治”就是唯一的一种凑法。
        for(int i = 0; i < len+1; i ++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < len+1; i++){
            for(int j = 1; j < amount+1; j ++){
                if(j <  coins[i-1]){
                    // 如果你不把这第 i 个物品装入背包，也就是说你不使用 coins[i] 这个面值的硬币，
                    // 那么凑出面额 j 的方法数 dp[i][j] 应该等于 dp[i-1][j]，继承之前的结果。继承上一行的结果
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 如果你把这第 i 个物品装入了背包，也就是说你使用 coins[i] 这个面值的硬币，
                    // 那么 dp[i][j] 应该等于 dp[i][j-coins[i-1]]。
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i -1]];
                }
            }
        }
        return dp[len][amount];
    }

    /**
     * 优化
     * @param amount
     * @param coins
     * @return
     */
    public static int getNum2(int amount, int[] coins){
        int len = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < len; i++){
            for (int j = 1; j < amount+1; j++){
                if(j < coins[i]){
                    continue;
                }else{
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
