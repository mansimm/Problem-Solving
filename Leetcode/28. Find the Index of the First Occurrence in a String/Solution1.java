/*Steps:
1.	Iterate over haystack chars using i var
2.	For each char store this i in k and start iterating over the needle using j
3.	For each haystack char at k compare with needle char at j, if they are not matching break inner loop
4.	At the end of inner loop check if j is equal to needle length means it matched and return i (start) value
5.	Else assign j=0 and continue outer loop
6.	In the end return -1, ie if not returned from loop means no match found
  */
class Solution1 {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int start = 0;
        
        for( i=0;i<haystack.length();i++){
            int k = i;
            for(j=0;j<needle.length() && k<haystack.length();j++){
                if(haystack.charAt(k) != needle.charAt(j)){
                    break;
                }else{
                    k++;
                }
            }
            if(j==needle.length()){
                return i;
            }else{
                j=0;
            }
        }
        return -1;
    }
}
//Time Complexity in worst case: O(m * n) where m = haystack length and n = needle length
//Space complexity: O(1)
