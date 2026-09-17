class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        
        int sorted[] = score.clone();
        Arrays.sort(sorted);
        String[] ans = new String[n];

        for(int i = n-1; i>=0 ; i--){

            int rank = n-i;

            int currscore = sorted[i];

            for(int j = 0; j<n; j++){
                if(score[j] == currscore && ans[j] == null){
                    if(rank == 1){
                        ans[j]= "Gold Medal";
                    }
                    else if(rank == 2){
                        ans[j]= "Silver Medal";
                    }
                    else if(rank == 3){
                        ans[j]= "Bronze Medal";
                    }
                    else{
                        ans[j]=String.valueOf(rank);
                    }
                    break;
                }
            }
        }
        return ans;
    }
}