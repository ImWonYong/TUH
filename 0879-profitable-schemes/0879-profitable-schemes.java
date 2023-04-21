class Solution {
    int mod = 1000000007;
    int[][][] memo = new int[101][101][101];
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        for (int i = 0; i <= group.length; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(0, 0, 0, n, minProfit, group, profit);
    }
    
    public int dfs(int i, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
        if (i == group.length) {
            return profit >= minProfit ? 1 : 0;
        }
        
        if (memo[i][count][profit] != -1) {
            return memo[i][count][profit];
        }
        
        int totalWays = dfs(i + 1, count, profit, n, minProfit, group, profits);
        if (count + group[i] <= n) {
            totalWays += dfs(i + 1, count + group[i], Math.min(minProfit, profit + profits[i]), n, minProfit, group, profits);
        }
        
        return memo[i][count][profit] = totalWays % mod;
    }
}

/*
    minProfit보다 많이 profit을 생성하고 최대 n명의 인원이 참석 가능하다
    할 수 있는 범죄 계획의 개수는??
*/