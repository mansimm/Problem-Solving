/*Steps:
1.	First, we will create array of rows, which will store word for each row, initialize by stringbuilder
2.	We will set direction using Boolean down flag, down true means going down the rows , false going up. 
3.	Also initialize down as false and initial row i=0
4.	Iterate over each character of string
5.	Append this char to current row stringbuilder and increment or decrement row counter based on down flag. If row in 0 or n-1 (first or last) then change down to !down.
6.	In the end join all row array element and return it
7.	Use StringBuilder to have mutable string.*/
class Solution {
    public String convert(String s, int numRows) {
        if(s.length()== 1 || s.length()<numRows){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new StringBuilder();
        }
        boolean goingDown = false;
        int currentRow = 0;
        for(char c: s.toCharArray()){
            rows[currentRow].append(c);
            if(currentRow==0 || currentRow==numRows-1){
                goingDown = !goingDown;
            } 
            if(numRows>1){
                 currentRow += goingDown ? 1: -1;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<numRows;i++){
            result.append(rows[i]);
        }
        return result.toString();
    }
}
/*
Time Complexity:
1.The algorithm iterates through each character in the input string exactly once. This is O(n), where n is the length of the input string.
2.The final step of combining all StringBuilder objects into one result is also O(n), as it involves appending all characters from all rows.
3.All other operations (creating the array of StringBuilders, changing directions, etc.) are constant time O(1) operations.
Therefore, the overall time complexity is O(n).

Space Complexity:
1.The algorithm creates an array of StringBuilder objects. The number of these objects is equal to numRows. This takes O(k) space, where k is numRows.
2.Each character from the input string is stored once in one of these StringBuilders. In total, this takes O(n) space, where n is the length of the input string.
3.The final result StringBuilder also contains all characters, which is another O(n) space.
4.All other variables (goingDown, currentRow, etc.) use constant space.
Therefore, the overall space complexity is O(n + k), which simplifies to O(n) since n (the length of the string) is typically much larger than k (the number of rows).
*/
