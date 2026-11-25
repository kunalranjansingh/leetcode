class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int window = 0;
        int count = 0;
        int target = k * threshold;

        // First window ka sum
        for (int i = 0; i < k; i++) {
            window += arr[i];
        }

        if (window >= target) {
            count++;
        }

        // Sliding window
        for (int right = k; right < arr.length; right++) {
            window += arr[right] - arr[right - k];

            if (window >= target) {
                count++;
            }
        }

        return count;
    }
}
