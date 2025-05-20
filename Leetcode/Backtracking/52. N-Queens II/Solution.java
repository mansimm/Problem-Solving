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
- Time Complexity: O(N^N)
- Space Complexity: O(N)
*/
