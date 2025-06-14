class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap();
        for(char c: magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c: ransomNote.toCharArray()){
            if(!map.containsKey(c) ||  map.get(c)<=0){
                return false;
            }else{
                map.put(c, map.getOrDefault(c, 0)-1);
            }
        }
        return true;
    }
}
//Time c = O(m+n) , space c = O(m) where m=length of ransomNote and n = length of magazine
