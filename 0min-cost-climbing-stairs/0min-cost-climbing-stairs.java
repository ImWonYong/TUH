class Solution {
    int[] memo;
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
        memo = new int[n];
        return Math.min(dfs(n - 1, cost), dfs(n - 2, cost));
	}
    
    // i 번째 계단에서 최소 비용
    public int dfs(int i, int[] cost) {
        if (i < 0) return 0;
        
        if (memo[i] != 0) {
            return memo[i];
        }
        
        memo[i] = cost[i] + Math.min(dfs(i - 1, cost), dfs(i - 2, cost));
        
        return memo[i];
    }
}

/*
    3가지를 찾아야 합니다.
    1. 재귀 함수의 리턴과 입력값
    2. 재귀식
    3. base case
    
    dfs(2) = cost[i] + min(dfs(1) , dfs(0));
*/