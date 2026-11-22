class Solution {
    public int minRange(int a, int b, int c) {
        int[] nums = {a,b,c};
        Arrays.sort(nums);

        int x = nums[0];
        int y = nums[1];
        int z = nums[2];

        if(x+y>z){
            return z-x;
        }else{
            return y;
        }
    }
}