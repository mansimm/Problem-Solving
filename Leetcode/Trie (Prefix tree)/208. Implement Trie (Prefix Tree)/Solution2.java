//better runtime
class TrieNode{
    TrieNode[] children = new TrieNode[26];
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
            int idx = c - 'a';
            if(current.children[idx]!=null){
                current = current.children[idx];
            }else{
                current.children[idx]=new TrieNode();
                current = current.children[idx];
            }
        }
        current.isLastNode = true;
    }
    
    public boolean search(String word) {
        TrieNode current = find(word);
        return current!=null && current.isLastNode;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = find(prefix);
        return current!=null;
    }
    public TrieNode find(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            int idx = c - 'a';
            if(current.children[idx]==null){
                return null;
            }else{
                current =current.children[idx];
            }
        }
        return current;
    }
}
/*
Time Complexity
  Insert Operation: O(m)
    m = length of the word being inserted
    For each character in the word:
  Calculate index: c - 'a' → O(1)
  Array access: current.children[idx] → O(1)
  Array assignment: current.children[idx] = new TrieNode() → O(1)
  Total: O(m) where m is word length
  Search Operation: O(m)
    Uses helper method find(word) → O(m)
    Check isLastNode → O(1)
  Total: O(m) where m is word length
  StartsWith Operation: O(p)
  Uses helper method find(prefix) → O(p)
  Total: O(p) where p is prefix length
  Find Helper Method: O(k)
  k = length of input string (word or prefix)
  For each character:
  Calculate index: O(1)
  Array access: O(1)
  Total: O(k)
Space Complexity
  Overall Space: O(26 × N × M)
  Where:
  26 = fixed alphabet size (lowercase letters a-z)
  N = number of words inserted
  M = average length of words
  Detailed Breakdown:
  1.TrieNode Structure:
  TrieNode[] children = new TrieNode[26];  // Always 26 slots
  boolean isLastNode;                      // 1 boolean
  Each node: 26 references + 1 boolean = O(26) = O(1)
  2.Total Nodes Created:
  Best case: Maximum prefix sharing → O(M) nodes
  Worst case: No prefix sharing → O(N × M) nodes
  Each node consumes exactly 26 reference slots
  3.Memory Usage Pattern:
  Total Space = Number of Nodes × 26 references per node
               = O(Number of Nodes × 26)
               = O(26 × N × M) in worst case
*/
