class Solution {
    int ans = 0;
    int total =0;
    public int uniquePathsIII(int[][] grid) {
         int m = grid.length;
         int n = grid[0].length;
         int x = 0;
         int y = 0; 

        for (int i = 0 ; i<m ; i++){
            for (int j =0 ; j<n ; j++){
                if (grid[i][j] != -1){
                    total++ ;
                }
                if (grid[i][j] == 1){
                    x = i ; 
                    y = j ;
                }
            }
        }

        solve(grid , x ,y , 0);
        return ans ; 
    }

        public void solve(int[][] grid , int i , int j , int visited){
            if (i<0 || j<0 || i>=grid.length || j>= grid[0].length 
            || grid[i][j] == -1){
                return;
            }
            
        

            if(grid[i][j] == 2){
                if(visited + 1 == total){
                    ans++ ;
                }
                return ;
            }
            int temp = grid[i][j];
            grid[i][j] = -1;

            solve(grid , i+1 , j , visited+1);
            solve(grid , i-1 , j , visited+1);
            solve(grid , i , j+1 , visited+1);
            solve(grid , i , j-1 , visited+1);

            grid[i][j] = temp;
        }
}