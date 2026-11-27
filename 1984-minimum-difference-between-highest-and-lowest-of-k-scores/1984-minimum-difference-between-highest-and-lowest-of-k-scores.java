import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i + k - 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                minDiff = Math.min(minDiff, diff);
                break;
            }
        }

        return minDiff;
    }
}