class Solution {
    public int maxPoints(int[][] points) {
       int n = points.length;
       if(n==1){
        return 1;
       } 
       int maxPointsInLine = 1;
      
       for(int i=0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            Map<String, Integer> lineMap = new HashMap(); 
            for(int j=i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dy = y2 - y1;
                int dx = x2 - x1; 
                int gcd = gcd(dx, dy);
                String slopeKey = dx/gcd+"."+dy/gcd;
                lineMap.put(slopeKey, lineMap.getOrDefault(slopeKey, 0)+1);
                maxPointsInLine = Math.max(maxPointsInLine, lineMap.get(slopeKey)+1);
            }
       }
       return maxPointsInLine;
    }
    
    // Helper method to calculate the greatest common divisor of two numbers
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
/*
Overall, the time complexity is O(n^2 * log(min(dx, dy))), since the gcd computation is the most significant operation in the inner loop.
O(n^2 * log(min(dx, dy)))
the worst-case space complexity is:
O(n^2)
*/
