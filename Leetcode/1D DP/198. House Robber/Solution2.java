//1D
class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int temp1 = nums[0];
        int temp2 = Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            int x =  temp2;
            temp2 = Math.max(temp1+nums[i], temp2);
            temp1 = x;
        }
        return temp2;
    }
}
//Time c O(n) and space c O(1)
