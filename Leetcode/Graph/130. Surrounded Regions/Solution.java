class Solution {
    int m,n;
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;

        //mark O which are at edge to T
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && (i==0 || i==m-1 || j==0 || j==n-1)){
                    capture(i,j,board);
                }
            }
        }
        //replace surrounded O by X
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        //replace T to O again (edge values)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void capture(int i, int j, char[][] board){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!='O'){
            return;
        }
        board[i][j] = 'T';
        capture(i,j+1,board);
        capture(i,j-1,board);
        capture(i-1,j,board);
        capture(i+1,j,board);
    }
}
//Time c = O(m*n) and space c = O(m*n) in worst case
