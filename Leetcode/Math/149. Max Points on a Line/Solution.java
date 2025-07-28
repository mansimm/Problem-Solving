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
Time Complexity: O(n² × log(min(dx, dy)))
Breakdown:
    1.Outer loop: Runs n times (for each point as a potential starting point)
    2.Inner loop: For each starting point i, runs n-i-1 times, which is O(n) in the worst case
    3.GCD calculation: For each pair of points, we calculate gcd(dx, dy) where:
    dx = x2 - x1 and dy = y2 - y1
    GCD using Euclidean algorithm has complexity O(log(min(a, b)))
    So GCD complexity is O(log(min(dx, dy)))
    Overall: O(n) × O(n) × O(log(min(dx, dy))) = O(n² × log(min(dx, dy)))
    In practice, since coordinate differences are typically bounded, the log factor is often considered constant, making it effectively O(n²).

Space Complexity: O(n²)
Breakdown:
    1.HashMap storage: For each starting point, we store slope keys in a HashMap
    2.Worst case scenario: All points have different slopes when paired with a single starting point
    3.Maximum entries: For starting point i, we can have at most n-i-1 different slopes
    4.Total space: In the worst case, we might store O(n) slope keys per starting point
    Overall: O(n²) in the worst case
    Note: The space complexity could be O(n) on average if many points share the same slopes, but O(n²) represents the worst-case scenario where every pair of points has a unique slope.

*/
