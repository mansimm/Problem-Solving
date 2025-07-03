	class TrieNode{
	    HashMap<Character, TrieNode> children = new HashMap();
	    boolean isLastNode; 
	}
	class Trie {
	    TrieNode root;
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    public void insert(String word) {
	        TrieNode current = root;
	        for(char c : word.toCharArray()){
	            if(current.children.containsKey(c)){
	                current = current.children.get(c);
	            }else{
	                current.children.put(c, new TrieNode());
	                current = current.children.get(c);
	            }
	        }
	        current.isLastNode = true;
	    }
	    
	    public boolean search(String word) {
	        TrieNode current = root;
	        for(char c: word.toCharArray()){
	            if(!current.children.containsKey(c)){
	                return false;
	            }else{
	                current = current.children.get(c);
	            }
	        }
	        return current.isLastNode;
	    }
	    
	    public boolean startsWith(String prefix) {
	        TrieNode current = root;
	        for(char c: prefix.toCharArray()){
	            if(!current.children.containsKey(c)){
	                return false;
	            }else{
	                current = current.children.get(c);
	            }
	        }
	        return true;
	    }
	}
/*
Time Complexity
Insert Operation: O(m)
m = length of the word being inserted
For each character in the word:
containsKey(): O(1) average case for HashMap
put(): O(1) average case for HashMap
get(): O(1) average case for HashMap
Total: O(m) where m is word length
Search Operation: O(m)
m = length of the word being searched
For each character in the word:
containsKey(): O(1) average case for HashMap
get(): O(1) average case for HashMap
Total: O(m) where m is word length
StartsWith Operation: O(p)
p = length of the prefix
Similar to search, but doesn't check isLastNode
For each character in prefix:
containsKey(): O(1) average case for HashMap
get(): O(1) average case for HashMap
Total: O(p) where p is prefix length
Space Complexity
Overall Space: O(ALPHABET_SIZE × N × M)
Where:
ALPHABET_SIZE = number of possible characters (e.g., 26 for lowercase letters)
N = number of words inserted
M = average length of words
Detailed Breakdown:
1.TrieNode Structure:
Each node contains:
HashMap for children: O(ALPHABET_SIZE) in worst case
boolean flag: O(1)
Per node space: O(ALPHABET_SIZE)
2.Total Nodes Created:
Best case: All words share common prefixes → O(M) nodes for longest word
Worst case: No shared prefixes → O(N × M) nodes
Average case: Depends on prefix overlap
3.HashMap Overhead:
Each HashMap has initial capacity and load factor overhead
In practice, most nodes won't use all possible characters
*/
