class Solution {
    public void reverseStringhelp(char[] s , int start , int end) {

        if (start>=end){
            return;
        }
        

        char temp = s[start];
        s[start] = s[end];
        s[end]=temp;

        reverseStringhelp(s,start+1,end-1);

    }
    public void reverseString(char[] s){
            reverseStringhelp(s,0,s.length-1);

    }
}