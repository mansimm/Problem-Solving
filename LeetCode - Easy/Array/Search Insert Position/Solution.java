class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int min=0;
        int max=nums.length-1;
        int mid= 0;
        
        if(target<nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;
        
        while(min<=max)
        {
            mid= (min+max)/2;
            if(nums[mid]==target)
            {
                System.out.println("mid="+mid);
                return mid;
            }
            else if(nums[mid]>target)
            {
                max=mid-1;
            }
            else 
            {
                min = mid+1;
            }
        }
        
        mid=(min+max)/2;
        if(nums[mid]>target)
        {
            if((mid-1)<0)return 0;
            return mid-1;
        }
        else
        {
            return mid+1;
        }
    }
}
