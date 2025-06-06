class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<nums[r]){//sorted
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
//Time c = O(logn) and space c = O(1)
