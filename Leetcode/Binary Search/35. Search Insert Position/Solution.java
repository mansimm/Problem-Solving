/*
Logic:
•	Follow binary search algorithm with some changes
•	Start=0 and end=nums.len, mid=(start+end)/2
•	If nums[mid]==target return mid
•	If target>nums[mid] set start=mid+1
•	Else set end = mid
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while(start<end){
            //check mid calculation and start end modifications are different
            int mid = (start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target>nums[mid]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}
//Time c = O(logn) and space O(1)
