/*
Steps:
1.	If s.lenght not equal to t.length return false
2.	Create a hashmap to store chars of s and their count
3.	Iterate over t and for each char check if it is present in map
4.	If not the return false
5.	If present check if count is >=1, else return false
6.	If count is >=1, then decrement count by 1
7.	In the end return true
  */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)>=1){
                    map.put(c, map.get(c)-1);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
//Time c. = O(N) space c. = O(1)
