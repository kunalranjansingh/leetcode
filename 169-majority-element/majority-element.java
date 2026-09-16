class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer , Integer> map = new HashMap<>();
        // int n= nums.length;
        
        // for(int i=0; i<n; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i] , 0)+1);
        // }

        // int max=0;
        // int answer = 0;

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     if(entry.getValue()>max){
        //         max = entry.getValue();
        //         answer = entry.getKey();
        //     }
        // }
        // return answer;

        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}