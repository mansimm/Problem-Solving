class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int profit = 0;
        //travel from left to right
        int min = prices[0];//min is min buy price
        for(int i=1;i<n;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            profit = prices[i] - min;
            left[i] = Math.max(left[i-1], profit);
        }
        int max = prices[n-1];//max sell price
        for(int i=n-2;i>=0;i--){
            if(prices[i]>max){
                max = prices[i];
            }
            profit = max - prices[i];
            right[i] = Math.max(right[i+1], profit);
        }
        int maxProfit = 0;
        for(int i=0;i<n;i++){
            int sum = left[i]+right[i];
            if(sum>maxProfit){
                maxProfit = sum;
            }
        }
        return maxProfit;
    }
}
//Time c = O(3n) => O(n), space c = O(2n)=> O(n)
