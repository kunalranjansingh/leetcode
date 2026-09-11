class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {

            // Starting point
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 0;

                while (set.contains(current)) {
                    length++;
                    current++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}