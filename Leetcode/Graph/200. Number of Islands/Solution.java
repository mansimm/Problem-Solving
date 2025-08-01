class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid == null||grid.length==0 || grid[0].length==0){
            return 0;
        }
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, char[][] grid){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';//marked visited
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }
}
//Time c = O(m*n) and space c = O(m*n) due to recursion depth
