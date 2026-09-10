class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> [] bucket = new List[nums.length+1];

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num=entry.getKey();
            int freq=entry.getValue();

            if(bucket[freq]== null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        int[] result = new int[k];
        int index = 0;

        for(int i=nums.length; i>=1 && index < k ; i--){
            
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    result[index] = num;
                    index++;

                    if(index==k){
                        break;
                    }
                }
            }
           
        }
    return result; 
    }
}