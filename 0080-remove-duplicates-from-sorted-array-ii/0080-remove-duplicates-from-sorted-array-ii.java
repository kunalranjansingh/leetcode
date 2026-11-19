class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length <= 2) {
            return nums.length;
        }
        int i=2 , j=2;
        while(j<n){
            if(nums[j]!= nums[i-2]){
                
                nums[i]=nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}