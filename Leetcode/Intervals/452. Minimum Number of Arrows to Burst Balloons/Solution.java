/*
Steps:
1.	First sort 2D array by comparing x2
2.	Then store x2 of first arr element in arrx, initialize cnt to 1
3.	Now iterate over arr using i=1, from first element
4.	For each element check if its x1 is greater than arrx, if yes means it cannot be burst by same arrow, so need to increment count and update arrx
5.	If not then continue loop
6.	Return count
  */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 1 || points.length == 0){
            return points.length;
        }
        Arrays.sort(points, Comparator.comparingInt(point->point[1]));
        int arrx = points[0][1];
        int cnt = 1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]>arrx){
                cnt++;
                arrx = points[i][1];
            }
        }
        return cnt;
    }
}
//Time O(nlogn), space O(n)
