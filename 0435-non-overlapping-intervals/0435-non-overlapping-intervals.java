class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int n= intervals.length;
        int count =0;
        int last_end = intervals[0][1];

        for(int i=1;i<n;i++){
            if(last_end>intervals[i][0]) count++;

            else last_end = intervals[i][1];
        }
        return count;
    }
    
}