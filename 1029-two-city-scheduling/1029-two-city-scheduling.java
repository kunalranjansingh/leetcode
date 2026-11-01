class Solution {
    public int twoCitySchedCost(int[][] arr) {
        Arrays.sort(arr,(a,b)-> 
        {
            return (a[0]-a[1]) - (b[0]-b[1]);
            });

        int price = 0;

        for(int i=0;i<arr.length/2;i++){
            price += arr[i][0];
        }
        for(int i=arr.length/2;i<arr.length;i++){
            price += arr[i][1];
        }
        return price;
        
    }
}