class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        memo = new int[amount];
        return dp(coins, amount);
    }
    
    // i 원일 때 가장 작은 동전 수
    public int dp(int[] coins, int i) {
        if (i < 0) return -1;
        if (i == 0) return 0;
        
        if (memo[i - 1] != 0) return memo[i - 1];
            
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dp(coins, i - coin);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        memo[i - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        
        return memo[i - 1];
    }
    
    /*
        1. return과 인자
        2. 재귀식
        3. base case
        
        
    */
}