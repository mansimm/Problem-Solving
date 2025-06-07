/*
Steps:
1.	Edge case: if s.length==0 or t.lenght==0 or s.length<t.length return “” empty string
2.	Create targetMap and store frequency of chars of t
3.	Create windowMap to store char frequency for current window
4.	Initialize left=0, right=0, count=0, minLeft=0(to store starting point of ans substring), minLength = Integer.max_value
5.	Now, we will use two pointers (left and right) to represent a "window" in the string s. The goal is to expand the window to include all characters from t and then shrink the window while still containing all characters.
•	Expand the window by moving the right pointer and adding characters to the windowMap.
•	Shrink the window by moving the left pointer when the window already contains all characters from t.
6.	Now iterate on right until s.length
7.	Fetch rightChar=s.charAt(right) and put it in windowMap with frequency (default 0, increment each time)
8.	If targetMap contains rightChar and its freq in targetMap and windowMap is same then we will increment count++
9.	While count==targetMap.size do following (window shrinking) 10, 11, 12 points
10.	If (right-left+1)< minLength, update minLength to (right-left+1), and minLeft=left.
11.	Char leftChar = s.charAt(left), decrease its frequency in windowMap
12.	Then check if leftChar present in targetMap and its freq in targetMap is more in than that in windowMap then do count--.
13.	After while ends do left++
14.	For outer while do right++
15.	In the end check if min window find, ie. minLength==Integer.Max then return “”,else return s,substring(minLeft, minLeft+minLength)
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0 || s.length()<t.length()){
            return "";
        }
        HashMap<Character, Integer> targetMap = new HashMap();
        for(Character c: t.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> windowMap = new HashMap();
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int minLeft = 0;

        while(right<s.length()){
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0)+1);
            if(targetMap.containsKey(rightChar) && targetMap.get(rightChar).intValue()==windowMap.get(rightChar).intValue())   {
                cnt++;
            }
            while(cnt == targetMap.size()){
                if(right-left+1 < minLength ){
                    minLength = right-left+1;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.getOrDefault(leftChar,0)-1);
                if(targetMap.containsKey(leftChar) && targetMap.get(leftChar).intValue() > windowMap.get(leftChar).intValue()){
                    cnt--;
                }
                left++;
            }
            right++;
        }
        return minLength==Integer.MAX_VALUE ? "": s.substring(minLeft,minLeft+minLength);
    }
}
/*
Let's analyze the time and space complexity of this solution:

Time Complexity: O(n)
1. We iterate through the string s once with the right pointer, which takes O(n) time, where n is the length of s.
2. The left pointer also moves through the string, but it never moves back, so its movement is also bounded by O(n).
3. All operations inside the loops (HashMap operations, character comparisons) are O(1) on average.
4. The initial creation of targetMap takes O(m) time, where m is the length of string t. However, m ≤ n, so this doesn't affect the overall complexity.
Therefore, the overall time complexity is O(n).
Space Complexity: O(k)
1. We use two HashMaps: targetMap and windowMap.
2. targetMap stores characters from string t, so its size is bounded by the number of unique characters in t, let's call this k1.
3. windowMap stores characters from the current window in s, so its size is bounded by the number of unique characters in s, let's call this k2.
4. We use a few integer variables (left, right, minLeft, minLen, count) which take constant space.
Let k be the total number of unique characters in both s and t. Then k ≤ k1 + k2.
Therefore, the space complexity is O(k).
In the worst case, if s and t contain all possible characters:
- For a standard ASCII character set (256 characters), k would be at most 256.
- For strings limited to lowercase and uppercase English letters, k would be at most 52.
In both cases, this is effectively constant space O(1) relative to the input size.
However, it's generally expressed as O(k) to account for potentially larger character sets or alphabets in different problem contexts.
*/
