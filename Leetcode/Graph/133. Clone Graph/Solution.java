class Node {
    public int val;
    public List<Node> neighbors;
}
 
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> oldToNew = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        return dfs(node);
    }
    private Node dfs(Node node){
        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }else{
            Node newNode = new Node(node.val);
            oldToNew.put(node, newNode);
            for(Node neighbor: node.neighbors){
                newNode.neighbors.add(dfs(neighbor));
            }
            return newNode;
        }
    }
}
/*
https://youtu.be/mQeF6bN8hMk?si=UZARiaYmIt6K3PdA
Time Complexity Breakdown:
HashMap operations: O(1) per operation × O(V) operations = O(V)
Node creation: O(1) per node × V nodes = O(V)
Edge traversal: Each edge traversed exactly once = O(E)
Total: O(V + E)
Space Complexity Analysis
Overall Space Complexity: O(V)
1. HashMap Storage:
HashMap<Node, Node> oldToNew = new HashMap();
Stores mapping for every node in the graph
Space: O(V)
2. Recursion Stack:
private Node dfs(Node node){
    // Recursive calls for each neighbor
    for(Node neighbor: node.neighbors){
        newNode.neighbors.add(dfs(neighbor));
    }
}
Stack depth analysis:
Best case: O(1) - Single node graph
Average case: O(log V) - Balanced graph structure
Worst case: O(V) - Linear chain graph
Worst case example:
1 → 2 → 3 → 4 → 5
DFS call stack: dfs(1) → dfs(2) → dfs(3) → dfs(4) → dfs(5) Stack depth: O(V)
3. Cloned Graph Storage:
Node newNode = new Node(node.val);
Creates V new nodes
Each node stores its neighbor list
Space: O(V + E) for the cloned graph structure
4. Input Space:
Original graph: O(V + E)
  */
