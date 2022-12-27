import java.util.Arrays;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;
        int[] remainBags = new int[capacity.length];

        for (int i = 0; i < remainBags.length; i++) {
            remainBags[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(remainBags);

        for (int i = 0; i < remainBags.length; i++) {
            if (additionalRocks - remainBags[i] >= 0) {
                additionalRocks -= remainBags[i];
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}
