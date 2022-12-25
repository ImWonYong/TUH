import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();


        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            int num = nums[i];
            int num2 = target - num;

            if (map.containsKey(num2) && map.get(num2) != i) {
                return new int[]{i, map.get(num2)};
            }
        }

        return null;
    }
}