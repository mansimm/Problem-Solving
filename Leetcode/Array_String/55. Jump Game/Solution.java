class Solution {
    public boolean canJump(int[] nums) {
        int finalPosition = nums.length -1;
        int j;
        for(j= finalPosition-1; j>=0;j--){
            if(j+nums[j] >= finalPosition){
                finalPosition = j;
            }
        }
        return finalPosition==0;
    }
}
