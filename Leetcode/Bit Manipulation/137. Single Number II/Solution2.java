class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        if(nums[1]!=nums[0]){
            return nums[0];
        }
        int n = nums.length;
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        for(int i = 1;i<n;i=i+3){
            if(nums[i]!=nums[i-1]){
                return nums[i-1];
            }
        }
        return -1;
    }
}
//Time c = O(nlogn) , space O(1)
