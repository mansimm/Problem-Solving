// 2D DP
class Solution1 {
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;// 1 way to reach if n=1
        dp[2] = 2;//2 ways to reach if n=2
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//Time c. O(n), space c O(n)
