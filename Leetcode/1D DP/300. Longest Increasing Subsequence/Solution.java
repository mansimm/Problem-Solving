class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int dp[] = new int[n];
        Arrays.fill(dp, 1);//initialize all elements to 1, we call also keep as 0, and while returning result return result+1
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(dp[i]>dp[max]){
                max=i;
            }
        }
        return dp[max];
    }
}
//Time c = O(n*n) and space c = O(1)
