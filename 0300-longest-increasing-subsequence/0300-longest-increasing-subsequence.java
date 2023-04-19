class Solution {
    /*
        DP 입니까? 그렇다면
        1. DP return과 state variable 선택
        2. 관계식 찾기
        3. base case
    */
    
    Map<Integer, Integer> memo = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // base case
        Arrays.fill(dp, 1);
        
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        
        return ans;
    }
    
}