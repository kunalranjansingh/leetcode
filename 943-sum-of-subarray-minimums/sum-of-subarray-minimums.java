class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int mod = 1000000007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        // Calculate contribution
        long sum = 0;

        for (int i = 0; i < n; i++) {

            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            long contribution = leftCount * rightCount * arr[i];

            sum = (sum + contribution) % mod;
        }

        return (int) sum;
    }
}