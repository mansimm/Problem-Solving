/*
Steps:
1.	Iterate over haystack and for each matching char with first char of needle, find substring from haystack of length k from this matching char
2.	Then compare this substring with needle, if matched return matching start position
3.	Note to iterate on haystack till (haystack.length()-k) to avoid index out of bound exception
  */
class Solution3 {
    public int strStr(String haystack, String needle) {
        int j = 0;
        int k = needle.length();
       for(int i=0;i<=haystack.length()-k;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                    String substr = haystack.substring(i, i+k);
                    if(needle.equals(substr)){
                        return i;
                    }
            }
       }
       return -1;
    }
}
/*
Time Complexity: O(m * n) Where:
m is the length of the haystack string
n is the length of the needle string
Explanation:
1.	The outer loop runs at most m - n + 1 times (which is O(m)).
2.	For each iteration where the first character matches:
substring() operation takes O(n) time.
equals() comparison takes O(n) time in the worst case.
3.	In the worst case (e.g., when haystack is "aaaa...a" and needle is "aaa...ab"), we perform these O(n) operations for almost every iteration of the loop.
Therefore, the worst-case time complexity is O(m * n).
Space Complexity: O(n)
Explanation:
4.	The algorithm uses a constant amount of extra space for integer variables (j, k, i).
5.	However, the substring() method creates a new String object of length n (where n is the length of needle) in each iteration where the first character matches.
6.	Although these substrings are temporary and eligible for garbage collection after each iteration, at any given time, we're using O(n) extra space.
Therefore, the space complexity is O(n).
  */
