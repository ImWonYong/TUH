class Solution {
    /*
        DP 입니까? 그렇다면
        1. DP return과 state variable 선택
        2. 관계식 찾기
        3. base case
    */
    
    Map<Integer, Integer> memo = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dp(i, nums));
        }
        
        return ans;
    }
    
    // dp의 return은 i까지의 최장 증가 부분수열, i는 입력 배열의 인데스
    public int dp(int i, int[] nums) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        int ans = 1;
        
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                ans = Math.max(ans, dp(j, nums) + 1);
            }
        }
        
        memo.put(i, ans);
        
        return ans;
    }
}