class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int j = 0;
        int i = j+1;
        while(i<nums.length){
            if(nums[i]!=nums[j]){
                nums[++j] = nums[i];
                i++;
            }else{
                i++;
            }
        }
        return j+1;
    }
}
