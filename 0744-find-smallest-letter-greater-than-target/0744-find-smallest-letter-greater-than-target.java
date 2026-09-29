class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left =0;
        int right = letters.length-1;

        char ans =letters[0];

        if(letters[right] <= target){
            return ans;
        }

        while(left<=right){
            int mid = left +(right-left)/2;
            char ch = letters[mid];

            if(ch > target){
                ans = ch;
                right = mid-1;
            }
            else {
                left = mid +1;
            }
        }
        return ans;
    }
}