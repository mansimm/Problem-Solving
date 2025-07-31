class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[k+1][n];
        for(int i=1;i<=k;i++){//transactions
            for(int j=1;j<n;j++){//daywise price
                dp[i][j] = Math.max(
            		solver(i, j, prices, dp),  // Best profit if we sell on day j
            		dp[i][j-1]                 // Best profit if we don't sell on day j
      		         );
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
/* How It Works
For each day j and transaction count i, the algorithm considers:
1.Don't sell today: Take the best profit from the previous day dp[i][j-1]
2.Sell today: Find the best day m to buy before day j, then:
Profit from this transaction: prices[j] - prices[m]
Plus best profit from i-1 transactions up to day m: dp[i-1][m]
Why dp[k+1][n] instead of dp[k][n]?
The Reason: 0-indexed transactions
The DP table needs to represent states from 0 transactions up to k transactions, which requires k+1 different states:
int dp[][] = new int[k+1][n];
                    ↑
                   k+1 rows needed

*/
