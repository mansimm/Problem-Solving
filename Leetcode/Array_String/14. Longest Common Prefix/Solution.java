/*
Steps:
1.	Find out shortest string in array
2.	Then for each ith char of shortestStr, iterate over array elements and compare their ith char
3.	If they are not matching then return shortestStr.substring(0, i), else continue above loop
  */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }    
        //find shortest string from array
        String shortestStr = strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length() < shortestStr.length()){
                shortestStr = strs[i];
            }
        }
        for(int i=0;i<shortestStr.length();i++){
            char c = shortestStr.charAt(i);
            for(String str: strs){
                if(str.charAt(i)!= c){
                    return shortestStr.substring(0,i);
                }
            }
        }
        return shortestStr;
    }
}
/*
1.Time Complexity: O(S), where S is the sum of all characters in all strings. In the worst case, all n strings are the same and have length m, so the time complexity would be O(n*m).
2.Space Complexity: O(1), as we only use a constant amount of extra space.
3.Efficiency: It doesn't create any new string objects until the end, making it memory-efficient.
*/
