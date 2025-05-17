class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        long[][] dp = new long[m+1][n+1];//to prevent integer overflow
        dp[0][1] = 1;//base case, alternatively we can also set dp[1][0]=1
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i-1][j-1]==0){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return (int)dp[m][n];
    }
}
//Time c O(m*n) , space O(m*n)
