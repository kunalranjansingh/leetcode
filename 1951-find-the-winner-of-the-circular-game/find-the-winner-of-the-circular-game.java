class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> friends = new LinkedList<>();
        for(int i =1 ; i<=n ; i++){
            friends.add(i);
        }
        for(int i=1; i<=n-1;i++){
            for(int j=1;j<k;j++){
                friends.add(friends.poll());
            }
            friends.poll();
        }
        return friends.poll();
    }
}