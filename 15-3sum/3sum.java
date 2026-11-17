class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            int j =i+1;
            int k= nums.length-1;
            while (j < k){
                if(nums[i]+nums[j]+nums[k] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[k]);
                hs.add(temp);
                j++;
            }
            else if(nums[i]+nums[j]+nums[k]>0){
                k--;
            }
            else{
                j++;
            }
        }
            }
            
        for(List<Integer> t : hs ){
            li.add(t);
        }
        return li;
    }
}