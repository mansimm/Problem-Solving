/*
Steps:
1.	We will create hashmap of (string, List<string>) to store, sorted key and its anagram 
2.	For each element in arr, we will convert in to arr, sort it and create string again
3.	We will check if this key present in hashmap If not present we will add key and empty list
4.	Then we will add original string in its value list
5.	In the end return new ArrayList(map.values())
  */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList());
            }
            map.get(sortedStr).add(s);
        }
        return new ArrayList(map.values());
    }
}
/*
Time Complexity:
1.The outer loop iterates through all strings in the input array strs. Let's say there are n strings.
2.For each string:
We convert it to a char array: O(k), where k is the length of the longest string
We sort the char array: O(k log k)
We convert the sorted char array back to a string: O(k)
We perform HashMap operations (containsKey, put, get): O(1) on average
3.Finally, we create a new ArrayList from the map values: O(n)
The dominant factor here is the sorting of each string. So, for n strings, each of maximum length k, the overall time complexity is:
O(n * k log k)
Space Complexity:
1.We create a HashMap that potentially stores all n strings.
2.For each unique anagram group, we store a list of strings.
3.In the worst case (no anagrams), we might store n lists, each containing one string.
4.The sorted strings are also stored as keys in the HashMap.
Therefore, the space complexity is O(n * k), where n is the number of strings and k is the maximum length of a string.
*/
