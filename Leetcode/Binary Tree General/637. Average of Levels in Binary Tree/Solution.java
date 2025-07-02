class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans = new ArrayList();
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            Double sum = 0.0;
            for(int i=0;i<size;i++){
                TreeNode node = que.remove();
                sum += node.val;
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
            ans.add((Double)(sum/size));
        }
        return ans;
    }
}
/*
Time Complexity: O(n)
The algorithm uses level-order traversal (BFS) to visit each node in the tree exactly once
Each node is processed exactly once: added to queue, removed from queue, and its value added to the sum
The outer while loop runs for the number of levels in the tree (h levels)
The inner for loop processes all nodes at each level
Total operations: n nodes × constant work per node = O(n)
Space Complexity: O(w) where w is the maximum width of the tree
The space is used by:
1.Queue storage: The primary space consumer
In the worst case, the queue contains all nodes at the widest level of the tree
For a complete binary tree: maximum width is at the last level ≈ n/2 nodes
For a skewed tree: maximum width is 1
General case: O(w) where w ≤ n/2
2.Result list: Stores one average per level
Number of levels = height of tree (h)
Space: O(h)
In worst case (skewed tree): h = n, so O(n)
In best case (balanced tree): h = log n, so O(log n)
3.Other variables: O(1) for sum, size, node, etc.
Overall Space Complexity: 
Worst case: O(n) - when the tree is either complete (wide) or completely skewed (tall)
Average case: O(w) where w is the maximum width
Summary:
Time: O(n) - linear in the number of nodes
Space: O(w) - linear in the maximum width of the tree, worst case O(n)
*/
