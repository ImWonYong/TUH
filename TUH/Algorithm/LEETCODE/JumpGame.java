class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int step = nums[0];
        int position = 0;

        for (int i = 1; i < nums.length; i++) {
            if (step == 0) return false;
            step--;
            position++;
            if (position == nums.length - 1) return true;
            if (step < nums[i]) {
                step = nums[i];
            }
        }
        return false;
    }
}