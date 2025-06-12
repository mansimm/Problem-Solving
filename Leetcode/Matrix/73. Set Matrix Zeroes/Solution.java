/*
Steps:
1.	We will create 2 sets to keep track of rows and column where matrix have zero.
2.	In next iteration on matrix, we will check if current row and col is present in our sets or not
3.	If present set current position element to zero
  */
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length; 
        Set<Integer> rowSet = new HashSet();
        Set<Integer> colSet = new HashSet();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rowSet.contains(i) || colSet.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
//Time c O(m*n), space c O(m+n)
