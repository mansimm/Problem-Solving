/*

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity of this solution is O(m+n).
*/
class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int i =0,j=0,k=0;
        int m[]=new int[nums1.length+nums2.length];
        
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                m[k++] = nums1[i++];
            }
            else
            {
                m[k++] = nums2[j++];
            }
        }
        while(i<nums1.length)
        {
            m[k++] = nums1[i++];
        }
        while(j<nums2.length)
        {
            m[k++] = nums2[j++];
        }
        
        if(m.length%2!=0)//odd
        {
            return m[m.length/2];
        }
        else//even
        {
            return (m[m.length/2]+m[(m.length-1)/2])/2.0;
        }
    }
}
