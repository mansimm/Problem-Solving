/*
Steps:
1.	We will first check if size of s and t are same or not, if not same return false
2.	Then create a map to store char mapping from s to t
3.	We will iterate over s and t using i var
4.	Fetch chars at i from s and t in a and b respectively
5.	Check if map contains key a, if yes we will check if its value is b, if not return false
6.	If map does not contains key a and value b then we will add (a,b) pair in map
7.	If map contains value b, return false. Bcoz no 2 chars can map to same value char 
  */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap();

        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(!map.containsKey(a)){
                if(!map.containsValue(b)){
                    map.put(a,b);
                }else{
                    return false;
                }
            }else {
                char value = map.get(a);
                if(value!=b){
                    return false;
                }
            }
        }
        return true;
    }
}
//Time c = O(n) and space c= O(1) because hashmap is stroring ascii chars whose size is fixed around 156
