class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> freq = new ArrayList<>(map.values());
        int count = map.size();
        Collections.sort(freq);
        for(int f : freq){
            if(k>=f){
                k = k-f;
                count--;
            }
            else{
                break;
            }
        }
        return count;
    }
}