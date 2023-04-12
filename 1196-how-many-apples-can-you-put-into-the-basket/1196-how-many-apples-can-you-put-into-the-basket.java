class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int ans = 0;
        int sum = 0;
        for (int w : weight) {
            sum += w;
            if (sum > 5000) {
                break;
            }
        
            ans++;
        }
        
        return ans;
    }
}