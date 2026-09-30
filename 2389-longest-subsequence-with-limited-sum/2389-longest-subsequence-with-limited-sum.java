class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] prefixsum = new int[nums.length];
        Arrays.sort(nums);
        prefixsum[0] = nums[0];

        for (int i=1 ; i<nums.length; i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }

        int[] ans = new int[queries.length];

        for(int k =0 ; k<queries.length ; k++){
            int query = queries[k];

            int left =0;
            int right = prefixsum.length-1;
            int count =0;

            while(left<=right){
                int mid = left+(right-left)/2;

                if(prefixsum[mid]<= query){
                    count = mid+1;
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            ans[k]= count;
        }
        return ans;
    }
}