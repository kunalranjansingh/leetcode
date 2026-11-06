class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            int curr = asteroids[i];
            boolean alive = true;

            while (!st.isEmpty() && st.peek() > 0 && curr < 0) {

                if (st.peek() < Math.abs(curr)) {
                    st.pop();
                }
                else if (st.peek() == Math.abs(curr)) {
                    st.pop();
                    alive = false;
                    break;
                }
                else {
                    alive = false;
                    break;
                }
            }

            if (alive) {
                st.push(curr);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i);
        }

        return ans;
    }
}