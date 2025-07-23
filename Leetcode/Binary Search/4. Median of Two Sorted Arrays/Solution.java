/*
Note: The median of a sorted array is the middle value that separates the higher half from the lower half. Here's how it's determined:
•	If the array has an odd number of elements, the median is the middle element.
•	If the array has an even number of elements, the median is the average of the two middle elements.

Steps:
1.Choose the smaller array to search in (for efficiency)
2.Imagine combining both arrays into one sorted array without actually doing it
3.Use binary search to find where to "cut" both arrays so that:
    Left side has same number of elements as right side (or one more)
    All left elements ≤ all right elements
4.Check the "cut" is valid:
    Largest element on left side of array1 ≤ smallest element on right side of array2
    Largest element on left side of array2 ≤ smallest element on right side of array1
5.Calculate median:
    If total elements is even: average of the two middle values
    If total elements is odd: the middle value

*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //take min length arr to perform binary search on it
        if(n1>n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int r = n1;
        while(l<=r){
            int partition1 = (l+r)/2;
            int partition2 = (n1+n2+1)/2 - partition1;

            int maxLeft1 = (partition1==0)?Integer.MIN_VALUE:nums1[partition1-1];
            int maxLeft2 = (partition2==0)?Integer.MIN_VALUE:nums2[partition2-1];
            int minRight1 = (partition1==n1)?Integer.MAX_VALUE:nums1[partition1];
            int minRight2 = (partition2==n2)?Integer.MAX_VALUE:nums2[partition2];

            if(maxLeft1<=minRight2 && maxLeft2<=minRight1){
                if((n1+n2)%2==0){
                    return (Math.max(maxLeft1, maxLeft2)+Math.min(minRight1, minRight2))*0.5;
                }else{
                    return Math.max(maxLeft1, maxLeft2);
                }
            }else if(maxLeft1 > minRight2){
                r = partition1-1;
            }else{
                l = partition1+1;
            }
        }
        throw new IllegalArgumentException();
    }
}
//Time c = O(log(min(m,n))), space c = O(1)
/*
Time Complexity: O(log(min(m, n)))
Breakdown:
1.Initial Setup: O(1)
2.Binary Search Loop: O(log(min(m, n)))
Why log(min(m, n))?
We always perform binary search on the smaller array
Binary search reduces search space by half each iteration
If smaller array has k elements, we need log(k) iterations
Since k = min(m, n), complexity is O(log(min(m, n)))
Space Complexity: O(1)
Breakdown:
1.Variables Used: O(1)
1.Variables Used: O(1)
int n1, n2;              // O(1) space
int l, r;                // O(1) space
int partition1, partition2; // O(1) space
int maxLeft1, maxLeft2;  // O(1) space
int minRight1, minRight2; // O(1) space
2.No Additional Data Structures: 
No arrays created
No recursion stack (except the initial swap call)
No dynamic memory allocation
3.Recursive Call Consideration:
Maximum one recursive call for swapping arrays
This adds O(1) to call stack, not O(n)
*/
