class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchPotentialRow(matrix, target);
        if(row!= -1){
            int col = binarySearchOverRow(row, matrix, target);
            if(col!=-1){
                return true;
            }
        }
        return false;
    }

    public int searchPotentialRow(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target){
                return mid;
            }
            if(target > matrix[mid][0]){
                start = mid+1;
            }else if(target < matrix[mid][0]){
                end = mid-1;
            }
        }
        return -1;
    }

    public int binarySearchOverRow(int row, int[][] matrix, int target){
        int start = 0;
        int end = matrix[0].length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(matrix[row][mid]==target){
                return mid;
            }
            if(target < matrix[row][mid]){
                end = mid - 1;
            }else if(target > matrix[row][mid]){
                start = mid + 1;
            }
        }
        return -1;
    }
}
//Time c = O(m*n) and space c = O(1)
