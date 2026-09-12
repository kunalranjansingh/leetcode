class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length()){
            return false;
        }
        HashMap <Character , Integer> map = new HashMap<>();

        for (int i= 0; i< s1.length(); i++){

            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        int k = s1.length();
        HashMap <Character , Integer> window = new HashMap<>();
        for (int right=0; right<s2.length(); right++){

            char ch = s2.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);

            if(right>=k){
                char remove = s2.charAt(right-k);
                window.put(remove,window.get(remove)-1);

                if(window.get(remove)==0){
                    window.remove(remove);
                }
            }
            if(window.equals(map)){
                return true;  
            }   
        }
        return false;
    }
}