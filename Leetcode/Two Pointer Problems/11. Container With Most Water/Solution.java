/*
Steps:
1.	Take 2 pointers i=0 and j=n-1
2.	For each i and j find area = min(arr[i],arr[j])*(j-i), if this is greater than maxArea assign it to maxArea
3.	Then check if arr[i]<arr[j], means we processed for height of i so do i++
4.	Else j--
*/
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length-1;
        while(i<j){
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(area, maxArea);
            if(height[i]<height[j]){// means we calculated area for height of i
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
/*
Time Complexity:
1.The method uses two pointers (i and j) that start at the beginning and end of the array respectively.
2.In each iteration of the while loop, either i is incremented or j is decremented.
3.The loop continues until i and j meet, which means it will run for at most n iterations, where n is the length of the input array.
4.Inside the loop, all operations (min, max, multiplication, comparison) are O(1).
Therefore, the overall time complexity is O(n), where n is the length of the input array.
Space Complexity:
1.The method uses only a constant amount of extra space:
maxArea, i, j, and area are all single integer variables.
2.No additional data structures are created.
3.The input array is not modified or copied.
4.The method doesn't use recursion, so there's no additional space used on the call stack.
Therefore, the space complexity is O(1) - constant space.
  */
