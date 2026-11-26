class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;

            if (k > 0) {
                // Sum next k elements
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // Sum previous k elements
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }

            result[i] = sum;
        }

        return result;
    }
}
