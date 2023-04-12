class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] info : boxTypes) {
            int boxCount = Math.min(truckSize, info[0]);
            truckSize -= boxCount;
            ans += info[1] * boxCount;
            
            if (truckSize == 0) break; 
        }
        
        return ans;
    }
}