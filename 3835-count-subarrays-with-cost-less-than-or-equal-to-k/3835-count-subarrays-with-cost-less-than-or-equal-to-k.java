class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {

            // Maintain maximum
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain minimum
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink window if cost > k
            while (left <= right) {
                long max = nums[maxDeque.peekFirst()];
                long min = nums[minDeque.peekFirst()];

                long len = right - left + 1;
                long cost = (max - min) * len;

                if (cost <= k) {
                    break;
                }

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}