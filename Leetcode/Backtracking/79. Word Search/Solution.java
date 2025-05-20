class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int i, int j, int s){
        if(i<0 || i>= board.length || j<0 || j>=board[0].length){
            return false;
        }
        if(word.charAt(s)!=board[i][j] || board[i][j] == '*'){
            return false;
        }
        if(s == word.length()-1){
            return true;
        }
        char cache = board[i][j];
        board[i][j] = '*';
        boolean isExists = backtrack(board, word, i, j+1, s+1) ||
                            backtrack(board, word, i+1, j, s+1) ||
                            backtrack(board, word, i, j-1, s+1) ||
                            backtrack(board, word, i-1, j, s+1);
        board[i][j] = cache;
        return isExists;
    }
}
/* This analysis will be based on the `exist` method and its helper `backtrack` method.

Time Complexity:

1. The `exist` method iterates through each cell of the board:
   - This takes O(M * N) time, where M is the number of rows and N is the number of columns in the board.

2. For each cell, it calls the `backtrack` method:
   - In the worst case, the `backtrack` method might explore all four directions for each character of the word.
   - This leads to a time complexity of O(4^L) for each cell, where L is the length of the word.

3. Combining these, the overall time complexity is O(M * N * 4^L).

Space Complexity:

1. The space used by the input:
   - The board: O(M * N)
   - The word: O(L)

2. The recursive call stack in `backtrack`:
   - In the worst case, the recursion depth could be equal to the length of the word.
   - This leads to O(L) space for the call stack.

3. No additional data structures are used that grow with the input size.

Therefore, the overall space complexity is O(M * N + L).
*/
