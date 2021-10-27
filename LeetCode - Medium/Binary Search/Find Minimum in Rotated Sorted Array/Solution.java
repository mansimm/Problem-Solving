class Solution {
    public int findMin(int[] nums) {
        
        int min = nums[0];
        int low =0;
        int high = nums.length-1;
        int mid = 0;
        
        while(low<=high)
        {
            mid = low + (high-low)/2;   
            if(nums[mid]<min)
            {
                min = nums[mid];
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
        }
        return min;
    }
}
