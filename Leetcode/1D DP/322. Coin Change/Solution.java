class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int n = coins.length;
        int[] memo = new int[amount+1];
        for(int i=1;i<=amount;i++){
            memo[i]=Integer.MAX_VALUE;
            for(int coin: coins){
                if(coin<=i && memo[i-coin]!=Integer.MAX_VALUE){
                    memo[i] = Math.min(memo[i], 1+memo[i-coin]);
                }
            }
        }
        if(memo[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return memo[amount];
    }
}
//Time c = O(Amount*n) space c = O(Amount)
