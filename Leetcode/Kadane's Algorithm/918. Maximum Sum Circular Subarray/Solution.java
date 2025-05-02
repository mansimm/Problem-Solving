class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int totalSum = 0;
        int currentMax = 0;
        int currentMin = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int n : nums){
            totalSum += n;
            currentMax = Math.max(currentMax+n, n);
            currentMin = Math.min(currentMin+n, n);
            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);       
    }
}
//Time c. O(n) and space c. O(1)
