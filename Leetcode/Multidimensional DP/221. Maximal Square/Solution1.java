class Solution1 {
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        this.dp = dp;
        int len = helper(0, 0, matrix);
        //find maxlen from dp
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]>len){
                    len = dp[i][j];
                }
            }
        }
        return len*len;
    }
    private int helper(int i, int j, char[][] matrix){
        if(i>=matrix.length || j>=matrix[0].length){
            return 0;
        }
        if(dp[i][j]==-1){
            int right = helper(i, j+1, matrix);
            int diag = helper(i+1, j+1, matrix);
            int down = helper(i+1, j, matrix);
            if(matrix[i][j]=='1'){
                dp[i][j] = 1+Math.min(right, Math.min(diag, down));
            }else{
                dp[i][j] = 0;
            }
        }
        return dp[i][j];//max length of square
    }
}
//Time c = O(m*n) , space c O(m*n)
