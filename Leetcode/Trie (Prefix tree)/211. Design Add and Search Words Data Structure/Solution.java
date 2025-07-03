	class TrieNode{
	    TrieNode[] children = new TrieNode[26];
	    boolean isLastNode;
	}
	class WordDictionary {
	    TrieNode root = null;
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    public void addWord(String word) {
	        TrieNode current = root;
	        for(char c : word.toCharArray()){
	            int idx = c - 'a';
	            if(current.children[idx]==null){
	                current.children[idx] = new TrieNode();
	                current = current.children[idx];
	            }else{
	                current = current.children[idx];
	            }
	        }
	        current.isLastNode=true;
	    }
	    
	    public boolean search(String word) {
	        return searchInNode(word, root);
	    }
	
	    public boolean searchInNode(String word, TrieNode root){
	        TrieNode current = root;
	        for(int i=0;i<word.length();i++){
	            char c = word.charAt(i);
	            if(c=='.'){
	                // If it's a wildcard, we need to check all possible paths
	                for(TrieNode node: current.children){
	                    if(node!=null && searchInNode(word.substring(i+1), node)){
	                        return true;
	                    }
	                }
	                return false;// If no paths find a match, return false
	            }else{
	                int idx = c-'a';
	                // If the specific child TrieNode does not exist, the word does not exist
	                if(current.children[idx]==null){
	                    return false;
	                }else{
	                    // Move to the next node
	                    current = current.children[idx];
	                }
	            }
	        }
	         // After processing all characters, check if it is the end of a word
	        return current.isLastNode;
	    }
	}
/*
📌 1. addWord(String word)
Time Complexity:
•	Loop runs word.length() times.
•	Each character insertion or traversal is O(1) (just indexing and checking).
✅ Time = O(L)
Where L is the length of the word.
Space Complexity:
•	In the worst case (new word, no shared prefix), creates a new TrieNode for each character.
✅ Space = O(L)
In worst case, 1 node per character.
________________________________________
📌 2. search(String word)
Worst Case Time Complexity:
Let:
•	L = length of the word
•	N = number of nodes in the Trie
Two cases:
________________________________________
🔹 Case A: No wildcards (.)
•	Works like a standard trie lookup:
•	Just one path followed, O(1) per character
✅ Time = O(L)
✅ Space = O(1)
________________________________________
🔹 Case B: With wildcards (.)
•	At each . character, may explore up to 26 branches.
•	This leads to a branching recursion tree.
In worst case:
•	All characters are . → fully explores Trie up to depth L
✅ Time = O(26^L) in the worst case
But usually much less in practice, depending on the Trie structure.
✅ Space = O(L) (recursion depth on call stack)
________________________________________
📦 Trie Space Usage (Global)
Over time, the Trie accumulates nodes.
•	Each unique path adds up to O(L) nodes.
•	Total space across all inserted words = O(N × L) in worst case, where:
o	N = number of inserted words
o	L = average word length
________________________________________
🔍 Summary
Method	Time Complexity	Space Complexity
addWord	O(L)	O(L) (for new nodes)
search (no .)	O(L)	O(1)
search (with .)	O(26^L) (worst case)	O(L) (recursion stack)
Total Trie Size	—	O(N × L)
*/
