class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0 ; i<p.length(); i++){
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        HashMap<Character , Integer> window = new HashMap<>();
        int left=0;

        for(int right =0; right<s.length(); right++){
            char ch =s.charAt(right);
            window.put(ch, window.getOrDefault(ch,0)+1);

            if(right-left +1 > p.length()){
                char remove = s.charAt(left);
                window.put(remove, window.get(remove)-1);

                if(window.get(remove)==0){
                    window.remove(remove);
                }
                left++;
            }

            if(window.equals(map)){
                result.add(left);
            }
        }
        return result;
    }
}