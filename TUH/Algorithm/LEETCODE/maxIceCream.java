class Solution {
    public int maxIceCream(int[] costs, int coins) {
        if (costs.length == 0) return 0;

        Arrays.sort(costs);
        int maxIceCream = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                maxIceCream++;
                coins -=costs[i];
            } else {
                break;
            }
        }
        
        return maxIceCream;
    }
}
