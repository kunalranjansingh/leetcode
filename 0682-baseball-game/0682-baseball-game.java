class Solution {
    public int calPoints(String[] operations) {

        int totalResult = 0;
        Stack<Integer> st = new Stack<>();

        for (int index = 0; index < operations.length; index++) {

            String number = operations[index];

            if (number.equals("+")) {

                int val1 = st.pop();
                int val2 = st.pop();

                int newK = val1 + val2;

                st.push(val2);
                st.push(val1);
                st.push(newK);

            } 
            else if (number.equals("C")) {
                st.pop();

            } 
            else if (number.equals("D")) {
                st.push(2 * st.peek());

            } 
            else {
                st.push(Integer.parseInt(number));
            }
        }

        while (st.size() > 0) {
            totalResult += st.pop();
        }

        return totalResult;
    }
}