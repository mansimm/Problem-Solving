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
✅ Time Complexity:
Let:
•	m=s1.length()m=s1.length()
•	n=s2.length()n=s2.length()
Each unique pair (i,j)(i,j) is computed at most once and stored in dp[i][j].
•	There are (m+1)×(n+1)(m+1)×(n+1) possible states.
•	Each state does constant work (character comparison and up to two recursive calls).
⏱ Time Complexity:
O(m×n)O(m×n)
________________________________________
✅ Space Complexity:
1.	DP Table:
•	dp is a 2D array of size (m+1)×(n+1)(m+1)×(n+1)
→ O(m×n)O(m×n)
2.	Call Stack (Recursion Depth):
•	In the worst case, recursion goes as deep as m+nm+n
→ O(m+n)O(m+n)
🧠 Total Space Complexity:
O(m×n) (DP table)+O(m+n) (call stack)=O(m×n)O(m×n) (DP table)+O(m+n) (call stack)=O(m×n)

*/
