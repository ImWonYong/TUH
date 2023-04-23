class Solution {
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        
        for (int start = 0; start < m; start++) {
            if (s.charAt(start) == '0') continue;
            
            for (int end = start; end < m; end++) {
                String currNum = s.substring(start, end + 1);
                
                if (Long.parseLong(currNum) > k) break;
                
                dp[end + 1] = (dp[end + 1] + dp[start]) % mod;
            }
        }
        
        return dp[m];
    }
}

/*
    Integer 배열을 프린트하는 프로그램
    배열의 숫자들이 [1, k] 사이의 숫자여야 한다.
    
    0으로 시작하는 것은 세지 않는다.
    dp[start] 는 해당 숫자부터 만들 수 있는 숫자 배열 갯수
*/