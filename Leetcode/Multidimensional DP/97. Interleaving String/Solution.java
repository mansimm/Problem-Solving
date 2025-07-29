class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n!=s3.length()) return false;
        int dp[][] = new int[m+1][n+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return solve(0, 0, s1, s2, s3, dp);
    }
    private boolean solve(int i, int j, String s1, String s2, String s3, int[][] dp){
        //k=i+j where k is length of s3
        if(i==s1.length() && j==s2.length()) return true;

        if(dp[i][j]!=-1) return dp[i][j]==1;
        boolean valid1 = false;
        boolean valid2 = false;
        if(i<s1.length() && (i+j)<s3.length() && s1.charAt(i)==s3.charAt(i+j)){
            valid1 = solve(i+1, j, s1, s2, s3, dp);
        }

        if(j<s2.length() && (i+j)<s3.length() && s2.charAt(j)==s3.charAt(i+j)){
            valid2 = solve(i, j+1, s1, s2, s3, dp);
        }
        dp[i][j] = (valid1 || valid2) ? 1:0;
        return (valid1 || valid2);
    }
}
/*
⏱️ Time Complexity
Let:
m = s1.length()
n = s2.length()
How many states can be computed?
Each state is uniquely defined by a pair (i, j) where:
0 <= i <= m
0 <= j <= n
Thus, there are (m + 1) × (n + 1) possible states.
Each state is computed at most once due to memoization.

Work per state:
Each state performs constant-time operations (charAt, comparisons, etc.) and up to 2 recursive calls.

Therefore:
Time Complexity: O(m * n)

🧠 Space Complexity
DP Table (dp):
Size: (m + 1) × (n + 1)
Space: O(m * n)
Recursive Call Stack (in worst case):
Depth: m + n (since each call either increases i or j)
Space: O(m + n) (maximum depth of recursion)

Therefore:
Space Complexity: O(m * n + m + n) = O(m * n)

(We generally consider DP table space as dominant.)
*/
