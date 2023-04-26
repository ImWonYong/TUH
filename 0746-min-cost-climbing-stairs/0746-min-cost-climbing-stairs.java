class Solution {
    // 무엇인가의 최대 최소, 이전의 결정에 다음 결정이 의존되어 있다 -> DP
	public int minCostClimbingStairs(int[] cost) {
		int minimumCost[] = new int[cost.length + 1];
        
        for (int i = 2; i < minimumCost.length; i++) {
            int oneStep = minimumCost[i - 1] + cost[i - 1];
            int twoStep = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(oneStep, twoStep);
        }
        
        return minimumCost[minimumCost.length - 1];
	}
    
}

/*
    3가지를 찾아야 합니다.
    1. 재귀 함수의 리턴과 입력값
    2. 재귀식
    3. base case
    
    dfs(2) = cost[i] + min(dfs(1) , dfs(0));
*/