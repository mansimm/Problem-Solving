/*
Logic:
•	We will follow binary search in 2 function findLeftBound(to find leftmost occurrence) and findRigthBound to find rightmost occurrence
•	findLeftBound: when target is found at mid we will not stop we will assign r=mid-1 and continue search to find leftmost occurrence
•	findRightBound: when target is found at mid we will not stop we will assign l=mid+1 and continue search to find leftmost occurrence
•	index variable is used to store latest index
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findLeftBound(nums, target);
        int end = findRightBound(nums, target);
        return new int[]{start, end};
    }
    public int findLeftBound(int nums[], int target){
        int l = 0;
        int r = nums.length-1;
        int index = -1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]==target){
                index = m;
                r = m-1;
            }
            else if(target<nums[m]){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return index;
    }
    public int findRightBound(int nums[], int target){
        int l = 0;
        int r = nums.length-1;
        int index = -1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m]==target){
                index = m;
                l = m+1;
            }
            else if(target<nums[m]){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return index;
    }
}
//Time c = O(logn) , space c = O(1)
