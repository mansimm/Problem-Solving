class Solution {
    public int removeElement(int[] nums, int val) {
        
        if(nums.length==0)
        {
            return 0;
        }
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=val)
            {
                int temp = nums[k];
                nums[k]=nums[i];
                nums[i]=temp;
                k++;
            }
        }
        return k;
    }
}
