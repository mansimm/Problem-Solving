//1DP
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];//to prevent integer overflow
        dp[0] = 1;
        //this solution process one row at a time
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[j]=0;
                }else if(j>0){//to prevent null pointer exception
                    dp[j] = dp[j] + dp[j-1];
                    //dp[j] is unique path till j from above row (from up)
                    //dp[j-1] is unique path from prev col(left)
                }
            }
        }
        return dp[n-1];
    }
}
//Time complexity : O(m*n) and space : O(n)
/*
Understanding the DP Array Values:
`dp[j]` (before update): Number of paths to reach position (i,j) from above (previous row)
`dp[j-1]`: Number of paths to reach position (i,j-1) from the left (current row)
`dp[j]` (after update): Total paths to reach position (i,j)
*/
