class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int maxvalue [] = new int[3];

        for (int triplet[] : triplets){
            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                maxvalue[0] = Math.max(triplet[0],maxvalue[0]);
                maxvalue[1] = Math.max(triplet[1],maxvalue[1]);
                maxvalue[2] = Math.max(triplet[2],maxvalue[2]);
            }
        }
        return maxvalue[0]==target[0] && maxvalue[1]==target[1] && maxvalue[2]==target[2];
    }
}