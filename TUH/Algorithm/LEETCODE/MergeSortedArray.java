class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for(int i = 0; i < m; i++) {
            nums3[i] = nums1[i];
        }

        int i = 0;
        int j = 0;
        while(i + j < nums1.length) {
            int index = i + j;
            if (i == nums3.length || j == nums2.length) {
                break;
            }

            if (i < nums3.length && nums3[i] <= nums2[j]) {
                nums1[index] = nums3[i];
                i++;
                continue;
            }

            if (j < nums2.length && nums3[i] > nums2[j]) {
                nums1[index] = nums2[j];
                j++;
            }
        }

        if (i != nums3.length) {
            for(int x = i + j; x < nums1.length; x++) {
                nums1[x] = nums3[i++];
            }
        }

        if (j != nums2.length) {
            for(int x = i + j; x < nums1.length; x++) {
                nums1[x] = nums2[j++];
            }
        }
    }
}