/*
Steps:
1.	we will create hashmap visited to keep track of visited charecters
2.	initialize start=0, end=0, window=0
3.	iterate over string using end 0 to n-1
4.	for each char str.charAt(end) check if it is in visited, if yes remove charAT(start) from hashmap and increment start. Repeat till str.charAT(end) is removed from hashmap
5.	now put charAT(end) in visited, calculate window size (j-i+1)
6.	and assign window = min( window, (j-i+1))
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1){
            return s.length();
        }
        int start = 0;
        int end = 0;
        int window = 0;
        HashMap<Character, Integer> visited = new HashMap();
        while(end<s.length()){
            while(visited.containsKey(s.charAt(end))){
                visited.remove(s.charAt(start));
                start++;
            }
            visited.put(s.charAt(end), 1);
            window = Math.max(window, end-start+1);
            end++;
        }
        return window;
    }
}
//Time c. = O(n), space c. = O(min(m,n)) where n is length of string and m is charecterSet 152 or 126
//https://youtu.be/gHNMSeeu_4Q?si=52qtwXB1lpYNS-jg
