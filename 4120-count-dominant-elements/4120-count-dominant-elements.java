class Solution {
    public int countDominantElements(int[] nums) {
        int dominant = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (n == 1) {
                dominant++;
            }
            else if (i == 0) {
                if (nums[i] >= nums[i + 1]) {
                    dominant++;
                }
            }
            else if (i == n - 1) {
                if (nums[i] >= nums[i - 1]) {
                    dominant++;
                }
            }
            else {
                if (2 * nums[i] >= nums[i - 1] + nums[i + 1]) {
                    dominant++;
                }
            }
        }

        return dominant;
    }
}