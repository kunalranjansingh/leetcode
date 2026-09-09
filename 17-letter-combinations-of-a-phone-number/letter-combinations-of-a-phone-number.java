class Solution {

    HashMap<Character, String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(digits, 0, "");

        return ans;
    }
    void solve(String digits, int index, String current) {

        // Combination complete
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        // Get letters for current digit
        String letters = map.get(digits.charAt(index));

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {

            solve(
                digits,
                index + 1,
                current + letters.charAt(i)
            );
        }
    }    
}