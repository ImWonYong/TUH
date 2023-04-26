class Solution {
    public int addDigits(int num) {
        int ans = 0;
        
        while (num > 0) {
            ans += num % 10;
            num /= 10;
            
            if (num == 0 && ans > 9) {
                num = ans;
                ans = 0;
            }
        }
        
        return ans;
    }
}

/*
    987654321
    9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1
    45
    9
    
*/