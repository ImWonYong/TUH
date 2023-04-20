class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        return dp(n);
    }
    
    public int dp(int i) {
        if (i == 0) {
            return 1;
        }
        
        if (i == 1) {
            return 1;
        }
        
        if (memo[i] != 0) {
            return memo[i];
        }
        
        memo[i] = dp(i - 2) + dp(i - 1);
    
        return memo[i];
    }
}
/*
    dp(0) = 1
    dp(1) = 1
    dp(2) = dp(1) + 1한칸 올라오거나, dp(0) + 2한번에 두칸 올라오거나, 2
    dp(3) = dp(2)에서 한칸 올라오거나 dp(1)에서 2칸 올라오거나, 3
    dp(3) = dp(3)에서 한칸 올라오거나 dp(2)에서 2칸 올라오거나

*/