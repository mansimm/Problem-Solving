/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    int[][] grid; 
    public Node construct(int[][] grid) {
        this.grid = grid;
        if(grid == null || grid.length==0){
            return null;
        }
        int n = grid.length;
        return build(0, n-1, 0, n-1);
    }
    public Node build(int rowStart, int rowEnd, int colStart, int colEnd){
        if(rowStart>rowEnd || colStart>colEnd){
            return null;
        }
        int val = grid[rowStart][colStart];
        boolean isLeaf = true;
        for(int i=rowStart;i<=rowEnd;i++){
            for(int j=colStart;j<=colEnd;j++){
                if(grid[i][j]!=val){
                    isLeaf = false;
                    break;
                }
            }
            if(!isLeaf){
                break;
            }
        }
        if(isLeaf){
            return new Node(val==1?true:false, isLeaf);
        }
        int rowMid = (rowStart+rowEnd)/2;
        int colMid = (colStart+colEnd)/2;
        Node topLeft = build(rowStart, rowMid, colStart, colMid);
        Node topRight = build(rowStart, rowMid, colMid+1, colEnd);
        Node bottomLeft = build(rowMid+1, rowEnd, colStart, colMid);
        Node bottomRight = build(rowMid+1, rowEnd, colMid+1, colEnd);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
//Time complexity O(n*n*log(n)) , space complexity O(logn)
