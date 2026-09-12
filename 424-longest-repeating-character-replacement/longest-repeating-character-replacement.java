class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character , Integer> map = new HashMap<>();
        int maxfreq = 0;
        int maxlength = 0;
        int left = 0;
        for (int right = 0; right< s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            maxfreq= Math.max(maxfreq,map.get(ch));

            while(right-left+1 - maxfreq > k){
                char remove = s.charAt(left);
                map.put(remove , map.get(remove)-1);
                if (map.get(remove) == 0){
                    map.remove(remove);
                }
                left++;
            }
            maxlength = Math.max(maxlength , right-left+1);
        }
        return maxlength;
    }
}