/*
Steps:
1.	Split s by “ “ into array of string
2.	We will first check if size of arr and pattern are same or not, if not same return false
3.	Then create a map to store char mapping from arr words  to pattern
4.	We will iterate over arr and pattern using i var
5.	Fetch string and chars at i from arr and pattern in a and b respectively
6.	Check if map contains key a, if yes we will check if its value is b, if not return false
7.	If map does not contains key a and value b then we will add (a,b) pair in map
8.	If map contains value b, return false. Bcoz no 2 chars can map to same value string

*/
class Solution {
	    public boolean wordPattern(String pattern, String s) {
	        String[] arr = s.split(" ");
	        if(arr.length!=pattern.length()){
	            return false;
	        }
	        HashMap<Character, String> map = new HashMap();
	        for(int i=0;i<pattern.length();i++){
	            char c = pattern.charAt(i);
	            String str = arr[i];
	
	            if(!map.containsKey(c)){
	                if(!map.containsValue(str)){
	                    map.put(c, str);
	                }else{
	                    return false;
	                }
	            }else{
	                String val = map.get(c);
	                if(!str.equals(val)){
	                    return false;
	                }
	            }
	
	        }
	        return true;
	    }
	}
//Time complexity O(n), space O(1)
