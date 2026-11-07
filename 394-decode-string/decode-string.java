class Solution {
    public String decodeString(String s) {

        Stack<String> sStrs = new Stack<>();
        Stack<Integer> sInts = new Stack<>();

        int count = 0;
        String s1 = "";

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                count = 10 * count + (c - '0');
            }

            else if (c == '[') {
                sStrs.push(s1);
                sInts.push(count);

                s1 = "";
                count = 0;
            }

            else if (c == ']') {

                String s2 = sStrs.pop();
                int n = sInts.pop();

                StringBuilder res = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    res.append(s1);
                }

                s1 = s2 + res.toString();
            }

            else {
                s1 = s1 + c;
            }
        }

        return s1;
    }
}