class Solution1 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        String arr[] = s.split(" +");//regex space+
        return arr[arr.length - 1].length();
    }
}
/*
1.Time Complexity: O(n), where n is the length of the input string.
The split(" +") method internally uses regex matching, which typically has a time complexity of O(n).
Accessing the last element of the array and getting its length are O(1) operations.
2.Space Complexity: O(n) in the worst case.
The split() method creates a new array of strings, which in the worst case (when every character is a word) could be as large as the input string
*/
