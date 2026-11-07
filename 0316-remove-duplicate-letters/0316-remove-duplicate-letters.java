class Solution {
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        // Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty() &&
                   stack.peek() > ch &&
                   lastIndex[stack.peek() - 'a'] > i) {

                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}