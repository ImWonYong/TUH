class Solution {
    public int maxSubArray(int[] nums) {
        return DAC(nums, 0, nums.length - 1);
    }

    public int DAC(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        if (left > right) return 0;

        int mid = (left + right) / 2;
        int temp = 0;
        int leftTemp = nums[mid];
        for (int i = mid; i >= left; i--) {
            temp += nums[i];
            if (temp > leftTemp) {
                leftTemp = temp;
            }
        }

        int rightTemp = nums[mid + 1];
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp += nums[i];
            if (temp > rightTemp) {
                rightTemp = temp;
            }
        }

        int leftMax = DAC(nums, left, mid);

        int rightMax = DAC(nums, mid + 1, right);

        return Math.max(Math.max(leftMax, rightMax), leftTemp + rightTemp);

    }


}