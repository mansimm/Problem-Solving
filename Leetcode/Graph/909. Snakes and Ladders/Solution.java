class Solution {
    public int snakesAndLadders(int[][] board) {
        int length = board.length;
        int target = length*length;
        
        HashSet<Integer> visited = new HashSet();
        Queue<int[]> que = new LinkedList();
        que.offer(new int[]{1,0});//square, move
        while(!que.isEmpty()){
            int[] pair = que.poll();
            int square = pair[0];
            int move = pair[1];
            if(square==target){
                return move;
            }
            for(int i=1;i<=6;i++){//check all 6 dice faces combinations
                int nextSquare = square+i;
                int[] pos = intToPos(nextSquare, length);
                int r = pos[0];
                int c = pos[1];
                if(r<length && c<length && board[r][c]!=-1){
                    nextSquare = board[r][c];
                }
                // if(nextSquare>target){
                //     break; // Stop if we've gone past the board
                // }
                if(nextSquare==target){//reached destination
                    return move+1;
                }
                if(!visited.contains(nextSquare)){
                    visited.add(nextSquare);
                    que.offer(new int[]{nextSquare, move+1});
                }
            }
        }
        return -1;
    }
    private int[] intToPos(int square, int length){
        int r = (square-1)/length;
        int c = (square-1)%length;
        if(r%2==1){//odd row(0,1,2,3) - traverse in reverse directions
            c = length-1-c;
        }
        return new int[]{length-1-r,c};// r modified to reverse board (row will move from bottom to up instead of top to down)
    }
}
//Time c = O(n*n) and space c O(n*n) 
