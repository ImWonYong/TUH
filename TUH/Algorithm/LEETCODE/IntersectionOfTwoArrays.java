import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1); // O(nlogn)
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (true) {
        if (i == nums1.length || j == nums2.length) break;

        if (nums1[i] == nums2[j]) {
        result.add(nums1[i]);
        i++;
        j++;

        continue;
        }

        if (nums1[i] > nums2[j]) {
        j++;
        continue;
        }

        if (nums1[i] < nums2[j]) {
        i++;
        }
        }

        return result.stream().mapToInt(num -> num).toArray();
        }
        }