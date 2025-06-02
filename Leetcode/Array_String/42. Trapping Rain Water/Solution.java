/*
Steps:
1.	Find maxLeft: max height column on left and maxRight: max height column on right at each location
2.	Find minimum of them at each location
3.	Then by using height of current column we can calculate water accumulated at current location
4.	At each location i, water accumulated is Math.min(leftmax[i], rightmax[i])-height[i]
Approach: two pointers approach
https://youtu.be/EdR3V5DBgyo
  */
class Solution {
    public int trap(int[] height) {
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;

        for(int i=0,j=height.length-1;i<j;){
            if(height[i]<=height[j]){
                //slop on i side so process i
                leftMax = Math.max(leftMax, height[i]);
                water += leftMax - height[i];
                i++;
            }else{
                //slop on j side so process j
                rightMax = Math.max(rightMax, height[j]);
                water += rightMax - height[j];
                j--;
            }
        }
        return water;
    }
}
//Time c = O(n) and space O(1)
