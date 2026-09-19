class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word:words){
            HashMap<Character , Character> map = new HashMap<>();
            boolean flag = true;
            for(int i=0; i<word.length(); i++){
                char ss = word.charAt(i);
                char tt = pattern.charAt(i);
                if(map.containsKey(ss) && map.get(ss)!= tt || !map.containsKey(ss) && map.containsValue(tt)){
                    flag = false;
                    break;
                }
                map.put(ss,tt);
            }
            if (flag){
                ans.add(word);
            }
        }
        
        return ans;     
    }
}