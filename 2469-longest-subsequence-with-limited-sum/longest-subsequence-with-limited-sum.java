class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] prefixsum = new int[nums.length];
        Arrays.sort(nums);

        
        prefixsum[0] = nums[0];

        TreeMap<Integer , Integer> map = new TreeMap<>();
        map.put(prefixsum[0] , 1);

        for (int i=1 ; i<nums.length; i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
            map.put(prefixsum[i] , i+1);
        }

        int k =0;
        int[] ans = new int[queries.length];

        for(int query:queries){
            Map.Entry<Integer , Integer> entry = map.floorEntry(query);

            if(entry != null){
                ans[k] = entry.getValue();
            }
            k++;
        }
        return ans;
    }
}