class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {

        List<List<String>> ans = new ArrayList<>();

        int i = 0;
        int n = s1.length();

        while (i < n) {

            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } 
            else {
                int start = i;

                while (i < n && s1.charAt(i) != s2.charAt(i)) {
                    i++;
                }

                String a = s1.substring(start, i);
                String b = s2.substring(start, i);

                ans.add(Arrays.asList(a, b));
            }
        }

        return ans;
    }
}