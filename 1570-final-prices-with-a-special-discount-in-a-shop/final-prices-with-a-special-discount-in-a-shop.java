class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> st = new Stack<>();

        int n = prices.length;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {

                int index = st.pop();
                prices[index] = prices[index] - prices[i];
            }

            st.push(i);
        }

        return prices;
    }
}