class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        //initialize base condition
        for(int i=0;i<=n;i++) dp[0][i]=i;
        for(int j=0;j<=m;j++) dp[j][0]=j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int topLeft = dp[i-1][j-1];
                    int top = dp[i-1][j];
                    int left = dp[i][j-1];

                    dp[i][j] = Math.min(topLeft, Math.min(top, left))+1;
                }
            }
        }
        return dp[m][n];
    }
}

//Time c = O(m*n) and space c = O(m*n)
