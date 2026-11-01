class Solution {
    public int jump(int[] nums) {
        int maxindex = 0,s=0,e=0,jump=0;
        int n=nums.length;
        while(s<n-1){
            maxindex = Math.max(maxindex,s+nums[s]);
            if(s==e){
                jump++;
                e=maxindex;
            }

            if(e==n-1) return jump;
            s++;

        }
        return jump;
    }
}