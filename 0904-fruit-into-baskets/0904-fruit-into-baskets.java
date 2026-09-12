class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int left = 0;
        int maxlength =0;
        for(int right = 0; right< fruits.length; right++){
            int fruit= fruits[right];
            map.put(fruit,map.getOrDefault(fruit , 0)+1);

            while(map.size() > 2){
                int remove = fruits[left];
                map.put(remove, map.get(remove)-1);

                if(map.get(remove)==0){
                    map.remove(remove);
                }
                left++;
            }
            maxlength=Math.max(maxlength , right-left+1);
        }
        return maxlength;
    }
}