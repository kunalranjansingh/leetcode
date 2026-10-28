class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int hour = 0 ; hour<12 ; hour ++){
            for (int min =0 ; min<60 ; min++){
                int bitcount = Integer.bitCount(hour) + Integer.bitCount(min);
                if(bitcount == turnedOn){
                    res.add(hour + ":" + String.format("%02d" , min));
                }
            }
        }
        return res;
    }
}