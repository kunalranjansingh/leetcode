class Solution {
    public boolean ispossible(int[] piles , int speed, int hour){
        long totalhour = 0;

        for(int pile:piles){
            totalhour = totalhour + (int) Math.ceil((double)pile/speed);
        }
        return totalhour <= hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;

        

        for (int pile:piles){
            max = Math.max(pile , max);
        }
        int low = min;
        int high = max;

        while(low<high){
            int mid = low +(high-low)/2;

            if(ispossible(piles , mid , h)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        
            
        return low;
    }
}