class Solution {
    int m;
    int n;
    int[][] memo;
    String t1;
    String t2;
    
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        
        t1 = text1;
        t2 = text2;
        
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return dp(0, 0);
    }
    
    /*
        1. return과 인자. text1의 길이가 i이고 text2의 길이가 j일 때 가장 긴 서브시퀀스??
    */
    public int dp(int i, int j) {
        if (i == m || j == n) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int ans = 0;
        if (t1.charAt(i) == t2.charAt(j)) {
            memo[i][j] = 1 + dp(i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dp(i + 1, j), dp(i, j + 1));
        }
        
        ans = memo[i][j];
        return ans;
    }
}

