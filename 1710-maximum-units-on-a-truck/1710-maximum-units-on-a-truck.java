class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        
        int box = 0;
        int ans = 0;
        for (int[] info : boxTypes) {
            for (int i = 0; i < info[0]; i++) {
                ans += info[1];
                box++;
                if (box == truckSize) {
                    return ans;
                }
            }
        }
        
        return ans;
    }
}