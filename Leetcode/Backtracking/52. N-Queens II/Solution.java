class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        backtrack(n, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
        return ans;
    }

    public void backtrack(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2){
        if(row==n){
            ans++;
            return;
        }
        for(int col=0;col<cols.length;col++){
            if(cols[col] || diag1[row+col] || diag2[col-row+n-1]){
                continue;
            }
            cols[col] = diag1[row+col] = diag2[col-row+n-1] = true;
            backtrack(n, row+1, cols, diag1, diag2);
            cols[col] = diag1[row+col] = diag2[col-row+n-1] = false;
        }
    }
}
/*
Time Complexity:
The time complexity is not actually O(N!), but closer to O(N!), specifically it's O(N^N).
Here's why:
1. At each row, we have at most N choices (columns) to place a queen.
2. We do this for N rows.
3. This gives us an upper bound of N^N possible configurations to check.
However, due to the pruning of invalid configurations using the boolean arrays, the actual number of configurations explored is much less than N^N in practice, but it's still exponential.

Space Complexity:
- The recursive call stack uses O(N) space.
- The boolean arrays (cols, diag1, diag2) use O(N) space each.
Therefore, the total space complexity is indeed O(N).

Summary -
- Time Complexity: O(N^N)
- Space Complexity: O(N)
*/
