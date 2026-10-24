class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(0, s, current, res);

        return res;
    }

    public void backtrack(int index, String s,
                          List<String> current,
                          List<List<String>> res) {

        if (index == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);

            if (isPalindrome(sub)) {
                current.add(sub);

                backtrack(i + 1, s, current, res);

                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}