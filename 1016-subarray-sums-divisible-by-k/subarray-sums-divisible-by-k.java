class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int prefixsum = 0;
        int count = 0;
        map.put(0,1);
        for(int num: nums){

            prefixsum += num;
            int rem = (prefixsum % k + k) % k;

            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}