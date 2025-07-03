class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}
class Solution {
    TrieNode root = new TrieNode();
    boolean visited[][];
    char board[][];
    List<String> res = new LinkedList();
    int m;
    int n;

    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words){
            insert(word);
        }
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char currChar = board[i][j];
                visited = new boolean[m][n];
                dfs(new StringBuilder(), i, j, root);
            }
        }
        return res;
    }
    public void dfs(StringBuilder sb, int row, int col, TrieNode current){
        //base case
        if(row<0 || row>=m || col<0 || col>=n) return;
        //if already visited
        if(visited[row][col]) return;
        char currChar = board[row][col];
        int idx = currChar - 'a';
        //if trie does not contains this char
        if(current.children[idx]==null) return;

        sb.append(currChar);
        current = current.children[idx];
        visited[row][col] = true;
        // add current char to res if it is word
        if(current.isWord){
            res.add(sb.toString());
            current.isWord = false;
        }

        //dfs on all 4 directions
        dfs(sb, row, col+1, current);//right
        dfs(sb, row+1, col, current);//down
        dfs(sb, row-1, col, current);//up
        dfs(sb, row, col-1, current);//left
        
        //remove last element: backtracking
        sb.setLength(sb.length()-1);
        visited[row][col]=false;
    }
    public void insert(String word){
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
        current.isWord = true;
    }
}
/*
🔍 Time Complexity (in worst case):
Starting DFS from every cell:
→ O(M * N)

DFS depth is limited to max word length L, because it only follows valid prefixes.

At each step in DFS:

Checks 4 directions (branching factor = 4)

Pruned by Trie (if path doesn't exist, it returns early)

Worst-case total DFS calls:

In pathological case (every path is valid), it's:

✅ O(M * N * 4^L)

But due to Trie pruning, in real input it's much less, so average-case is significantly faster.

🔍 Space Complexity:
Trie Storage:

One node per unique character in all words

Worst case (no prefix sharing): O(W * L)

Visited Array:

New visited[m][n] created for each DFS call

Each one is O(M * N) — but reused during recursion, so not cumulative.

Call Stack (DFS recursion depth):

Up to L deep (max word length)

Result list (res) and StringBuilder (sb):

res stores up to W words → O(W * L)

sb is temporary and max length = L

✅ Overall Space:
O(W * L + M * N)
(Trie + visited + result storage)

📦 Final Complexity Summary
Part	           Time Complexity	        Space Complexity
insert(words)	   O(W * L)           	    O(W * L)
findWords() DFS	 O(M * N * 4^L) (worst)	  O(W * L + M * N)
Average DFS case	much faster due to Trie pruning	—

*/
