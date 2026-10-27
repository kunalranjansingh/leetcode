import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        int n = s.length();

        if (n < 4 || n > 12) {
            return ans;
        }

        backtracking(s, ans, temp, 0, 3);

        return ans;
    }

    boolean check(String s) {
        int n = s.length();

        if (n > 3 || n == 0) {
            return false;
        }

        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        if (Integer.valueOf(s) > 255) {
            return false;
        }

        return true;
    }

    public void backtracking(String s, List<String> ans,
                             List<String> temp, int index, int dots) {

        if (dots == 0) {
            String last = s.substring(index);

            if (check(last)) {
                temp.add(last);
                ans.add(String.join(".", temp));
                temp.remove(temp.size() - 1);
            }

            return;
        }

        for (int i = index; i < s.length() && i < index + 3; i++) {
            String part = s.substring(index, i + 1);

            if (check(part)) {
                temp.add(part);

                backtracking(s, ans, temp, i + 1, dots - 1);

                temp.remove(temp.size() - 1);
            }
        }
    }
}