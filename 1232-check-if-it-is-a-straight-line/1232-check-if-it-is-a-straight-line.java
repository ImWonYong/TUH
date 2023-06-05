class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        int diffX = x2 - x1;
        int diffY = y2 - y1;
        
        for (int i = 2; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            
            if (diffY * (x3 - x1) != diffX * (y3 - y1)) {
                return false;
            }
        }
        
        return true;
    }
}