class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //first row and column of dp will be all 0, base condition, actual values will be stored  from dp[1][1]
                if(matrix[i][j]=='1'){
                    dp[i+1][j+1] = 1 + Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j]));//min heare
                    max = Math.max(dp[i+1][j+1], max);//max here
                }
            }
        }
        return max*max;
    }
}
//Same complexities better runtime.
