class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) return dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (i - 2 >= 0) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);   
            } else {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            }
            
        }
        
        return dp[nums.length - 1];
    }
}