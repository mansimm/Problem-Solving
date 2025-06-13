/*
Steps:
Logic:
1.	Iterate over each element of matrix
2.	Find count of living neighbor (1) around it in lives var.
3.	If currents value is 0, then if lives == 3, it will become alive, so we will mark it as -1
4.	If currents value is 1, then if lives<2 or lives>3, it will die, so we will mark it as 2
5.	-1 means going to live (originally dead ie. 0), 2 means going to die (originally live ie. 1)
6.	After all iterations, call update function to update -1 and 2 to 1 and 0 respectively
Count: 
1.	This function counts the number of live cells surrounding current cell
2.	For this we initialize directions array, which gives pairs which we need to add to current [i][j] to get its neighbor
3.	Then we will iterate on direction pairs and add it to current I,j.
4.	We will increment count if element at that neighbor location is 1 or 2
5.	2 indicate that it’s original value was 1, but due to neighboring conditions it going to die, so marked as 2 
Update:
1.	This function iterates over matrix and modify values as follows
2.	If currents value is -1, change it to 1
3.	If currents value is 2, change it 0 
  */
class Solution {
    static int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==0){
                    int lives = count(board, i, j);
                    if(lives==3){
                        board[i][j] = -1;
                    }
                }else if(board[i][j]==1){
                    int lives = count(board, i, j);
                    if(lives<2 || lives>3){
                        board[i][j] = 2;
                    }
                }
            }
        } 
        updateBoard(board);
    }

    public int count(int[][] board, int row, int col){
        int cnt = 0;
        for(int[] dir: dirs){
            int r = row+dir[0];
            int c = col+dir[1];
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && 
            (board[r][c]==1 || board[r][c]==2)){
//2 means it was alive but marked 2 to make it dead, so we are considering original value
                cnt++;
            }
        }
        return cnt;
    }
    public void updateBoard(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-1){
                    board[i][j] = 1;
                }
                else if(board[i][j]==2){
                    board[i][j] = 0;
                }
            }
        }
    }
}
//Time c. O(m*n), space c. O(1)
