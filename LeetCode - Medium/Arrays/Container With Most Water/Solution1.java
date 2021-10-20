// complexity => O(n)

class Solution {
    public int maxArea(int[] height) {
        
        int area = 0;
        int i=0, j=height.length-1;
        
        while(i<j)
        {
            int h = height[i]<height[j] ? height[i] : height[j];
            int w = j-i;
            if((h*w)>area)
            {
                area = h*w;
            }
            if(height[i]<height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return area;
    }
}
