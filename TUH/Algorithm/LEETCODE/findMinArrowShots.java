class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingLong((int[] o) -> o[1])); 

        int arrows = 1;
        int pre = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[pre][1]) {
                arrows++;
                pre = i;
            }
        }

        return arrows;
    }
}
