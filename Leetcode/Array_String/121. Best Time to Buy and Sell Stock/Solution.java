class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int i=0;
        int j=1;
        while(j<prices.length){
            if(prices[j]-prices[i]<0){
                i=j;
                j++;
            }else{
                if(prices[j]-prices[i] > max){
                    max = prices[j]-prices[i];
                }
                j++;
            }
        }
        return max; 
    }
}
