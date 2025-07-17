/*
Logic:
•	Use binary search, find mid=(l+r)/2
•	If nums[mid]<nums[r] means this part is sorted assign r=mid
•	Else assign l=mid+1
•	Return nums[l] it will be minimum in the end
*/
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
