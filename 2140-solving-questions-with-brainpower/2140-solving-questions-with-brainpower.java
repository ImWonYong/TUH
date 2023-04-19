class Solution {
    long[] dp;
	public long mostPoints(int[][] questions) {
		int n = questions.length;
        dp = new long[n];
        
        return dfs(questions, 0);
	}
    
    public long dfs(int[][] questions, int i) {
        if (i >= questions.length) {
            return 0;
        }
        
        if (dp[i] != 0) {
            return dp[i];
        }
        
        dp[i] = Math.max(questions[i][0] + dfs(questions, i + questions[i][1] + 1), dfs(questions, i + 1));
        
        return dp[i];
    }
}