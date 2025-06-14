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
