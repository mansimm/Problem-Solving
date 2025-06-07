/*Steps:
1.	We will create set names seen to maintain track of values
2.	Iterate over matrix
3.	For each element we will add its entry in seen with String as num is at row i, num is at col j and num is at box i/3-j/3 
4.	If element is already present in same row or col or box add will return false, then we will return false as sudoku is invalid
5.	In the end return true
  */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(num!='.'){
                    if(!seen.add(num +" is at row "+i) ||
                    !seen.add(num+" is at col "+j)||
                    !seen.add(num+"is at box "+i/3+"-"+j/3)){
                        //above if returns false means not added => duplicates
                        return false;
                    }
                }
            }
        }
        return true;        
    }
}
// Time complexity would be O(N^2)
// Space complexity would be O(N^2)
