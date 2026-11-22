class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] ans = new String[n];

        int alice=0;
        int bob=0;

        for(int i=0;i<n;i++){
            if(rain[i]==0){
                ans[i] = "None";
            }
            else if(i<n-1 && alice<=bob && rain[i+1]==1){
                ans[i] = "Alice";
                alice++;
            }
            else{
                ans[i] = "Bob";
                bob++;
            }
        }
        return ans;
    }
}