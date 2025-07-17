/*Logic:
•	We will use binary search with some additional checks to see if left or right side is sorted
•	If num[mid]==target return mid
•	Else check if left is sorted (nums[mid]>=nums[l]) if yes see if target>=nums[l] && target<nums[mid] then r=mid-1 else l=mid+1
•	If left side is not sorted, then check if target>nums[mid] && target<=target[r] if yes set l=mid+1 else r=mid-1
•	In the end return -1
*/
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[m]>=nums[l]){// l to m are sorted
                if(target<nums[m] && target>=nums[l]){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }else{// m to r are not sorted
                if(target>nums[m] && target<=nums[r]){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
        }
        return -1;
    }
}
//Time c = O(n), space c = O(1)
