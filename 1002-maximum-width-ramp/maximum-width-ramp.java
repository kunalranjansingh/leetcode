class Solution {
    public int maxWidthRamp(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int n = nums.length;

        // First traversal: Store decreasing elements' indexes
        for (int i = 0; i < n; i++) {

            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int ans = 0;

        // Second traversal: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {

                ans = Math.max(ans, i - stack.pop());
            }

            if (stack.isEmpty()) {
                break;
            }
        }

        return ans;
    }
}