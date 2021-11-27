/*
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

=>

	1  2  3  4  5  6  7

let n = nums.length

1)reverse 0 to n-1 = 0 to 6

	7  6  5  4  3  2  1

2)reverse 0 to k-1 = 0 to 2

	5  6  7  4  3  2  1

3)reverse k to n-1 = 3 to 6

	5  6  7  1  2  3  4
*/


class Solution {
    public void rotate(int[] nums, int k) {
      
        k = k%nums.length;
        
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
       
    }
    public void reverse(int[] arr, int start, int end)
    {
        for(int i=start,j=end;j>i;i++,j--)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
