class Solution {
    public int minOperations(int[] nums, int x) {

        int sum = 0;
        int n = nums.length;

        for (int i : nums) {
            sum += i;
        }

        int target = sum - x;
        int currSum = 0;
        int maxLen = 0;
        int left = 0;
        boolean found = false;

        for (int right = 0; right < n; right++) {

            currSum += nums[right];

            while (left <= right && currSum > target) {
                currSum -= nums[left];
                left++;
            }

            if (currSum == target) {
                found = true;
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return found ? n - maxLen : -1;
    }
}