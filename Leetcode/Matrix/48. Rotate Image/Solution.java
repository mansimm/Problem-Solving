// Steps:
// 1.	Reverse all rows[]
// 2.	Then take transpose of matrix (ie. Swap matrix[i][j] with matrix[j])
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //step: reverse all rows
        for(int i=0,j=n-1;i<j;i++,j--){
            int temp[] = matrix[i];
            matrix[i] = matrix[j];
            matrix[j]=temp;
        }
        //step2: transpose matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
// Time Complexity: O(m*n)
// Space complexity: O(1)
