class Solution {

    public int searchfirst(int[] nums, int target){

        int left =0;
        int right = nums.length-1;
        int firstidx = -1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid] == target){
                firstidx = mid;
                right = mid-1;
            }
            else if (nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return firstidx;

    }
    public int searchlast(int[] nums, int target){

        int left =0;
        int right = nums.length-1;
        int lastidx = -1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid] == target){
                lastidx = mid;
                left = mid +1;
            }
            else if (nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return lastidx;

    }
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }

        int first = searchfirst(nums,target);
        int last = searchlast(nums,target);

        return new int[] {first , last};
    }
}