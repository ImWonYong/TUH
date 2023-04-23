class Solution {
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int[] dp = new int[m + 1];
        return dfs(dp, 0, s, k);
    }
    
    public int dfs(int[] dp, int start, String s, int k) {
        if (dp[start] != 0) {
            return dp[start];
        }
        
        if (start == s.length()) {
            return 1;
        }
        
        if (s.charAt(start) == '0') {
            return 0;
        }
        
        int count = 0;
        for (int end = start; end < s.length(); end++) {
            String currNum = s.substring(start, end + 1);
            if (Long.parseLong(currNum) > k) {
                break;
            }
            count = (count + dfs(dp, end + 1, s, k)) % mod;
        }
        dp[start] = count;
        return dp[start];
    }
}

/*
    Integer 배열을 프린트하는 프로그램
    배열의 숫자들이 [1, k] 사이의 숫자여야 한다.
    0으로 시작하는 것은 세지 않는다.
    
    dp[start] 는 해당 숫자부터 만들 수 있는 숫자 배열 갯수
*/