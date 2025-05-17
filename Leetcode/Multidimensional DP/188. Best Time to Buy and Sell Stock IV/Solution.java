class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[k+1][n];
        for(int i=1;i<=k;i++){//transactions
            for(int j=1;j<n;j++){//daywise price
                dp[i][j]=Math.max(solver(i, j, prices, dp), dp[i][j-1]);
            }
        }
        return dp[k][n-1];
    }
    private int solver(int i, int j , int[] prices, int[][] dp){
        int maxProfit = Integer.MIN_VALUE;
        for(int m=0;m<j;m++){
            int profit = prices[j]-prices[m]+dp[i-1][m];
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
//Time c = O(k*n*n), space c = O(k*n)
