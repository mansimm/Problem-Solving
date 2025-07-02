/*https://youtu.be/d4zLyf32e3I?si=Sv8eBsmnmcSNGJD4
Hint:
1.	we will create a queue
2.	for each level, node from left to right will be stored in que
3.	size denotes the number of nodes in current level
4.	at the end of iteration on each level last node ie. Rightmost node will be added in ans list 
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            TreeNode rightMostNode = null;
            for(int i=0;i<size;i++){
                TreeNode node = que.remove();
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
                rightMostNode = node;
            }
            if(rightMostNode!=null){
                ans.add(rightMostNode.val);
            }
        }
        return ans;
    }
}
/*
Time Complexity: O(n)
The algorithm uses level-order traversal (BFS) to visit each node in the tree exactly once
Each node is added to and removed from the queue once
The outer while loop runs for the number of levels in the tree
The inner for loop processes all nodes at each level
Total operations: n nodes × constant work per node = O(n)
Space Complexity: O(w) where w is the maximum width of the tree
The space is used by:
1.Queue storage: In the worst case, the queue will contain all nodes at the widest level of the tree
For a complete binary tree, the maximum width is at the last level: approximately n/2 nodes
For a skewed tree, the maximum width is 1
In general: O(w) where w ≤ n/2
2.Result list: Stores one value per level, so O(h) where h is the height of the tree
3.Other variables: O(1) for temporary variables
Overall Space Complexity: O(w) dominates, which in the worst case is O(n) for a complete binary tree.
  */
