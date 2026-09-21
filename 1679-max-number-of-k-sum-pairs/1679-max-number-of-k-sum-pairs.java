class Solution {
    public int maxOperations(int[] nums, int k) {
        // Arrays.sort(nums);
        // int left =0;
        // int right = nums.length-1;
        // int count =0;

        // while(left<right){
        //     if(nums[left]+nums[right]<k){
        //         left++;
        //     }
        //     else if(nums[left]+nums[right]>k){
        //         right--;
        //     }
        //     else{
        //         left++;
        //         right--;
        //         count++;
        //     }
        // }
        // return count;
        HashMap<Integer , Integer> map = new HashMap<>();
        int count =0;
        for(int num : nums){
            int required = k- num;

            if(map.getOrDefault(required,0)>0){
                count++;
                map.put(required , map.getOrDefault(required , 0)-1);
            }
            else{
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return count;
    }
}