//Brute force-
//time limit exceeded

class Solution {
    public int maxArea(int[] height) {
        
        int area = 0;
        for(int i=0;i<height.length;i++)
        {
            for(int j=i+1;j<height.length;j++)
            {
                
                    int h = height[i] < height[j] ? height[i]: height[j];
                    int w = j-i;
                    if((h*w)>area)
                    {
                        area = h*w;
                    }
                
            }
        }
        return area;
    }
}
