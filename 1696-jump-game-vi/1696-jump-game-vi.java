class Solution {
    public int maxResult(int[] nums, int k) {

        int n = nums.length;
        int[] dp = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();

        dp[0] = nums[0];
        dq.offerLast(0);

        for (int i = 1; i < n; i++) {

            // Remove indices outside window
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            // Calculate current maximum score
            dp[i] = nums[i] + dp[dq.peekFirst()];

            // Maintain decreasing DP values
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return dp[n - 1];
    }
}