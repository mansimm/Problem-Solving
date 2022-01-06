class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing=true, decreasing=true;
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>nums[i])
            {
                increasing = false;
                break;
            }
        }
        //System.out.println("increaseing: "+increasing);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]<nums[i])
            {
                decreasing = false;
                break;
            }
        }
        //System.out.println("decreasing: "+decreasing);
        return increasing || decreasing;
    }
}
