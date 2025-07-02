class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        prev = null;
        inorder(root);
        return minDiff;
    }
    public void inorder(TreeNode node){
        if(node==null){
            return; 
        }
        inorder(node.left);
        if(prev!=null){
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node;
        inorder(node.right);
    }
}
/*
Time Complexity: O(n)
The algorithm performs an in-order traversal of the BST
Each node is visited exactly once during the traversal
At each node, constant time operations are performed:
Comparison with previous node (O(1))
Math.min calculation (O(1))
Assignment operations (O(1))
Total: n nodes × O(1) work per node = O(n)
Space Complexity: O(h) where h is the height of the tree
The space is consumed by:
1.Recursive call stack: The primary space consumer
Maximum depth of recursion equals the height of the tree
Each recursive call adds a frame to the call stack
Space: O(h)
2.Instance variables: O(1)
minDiff: stores one integer value
prev: stores reference to one TreeNode
These don't grow with input size
Height-based analysis:
Best case (balanced BST): h = O(log n) → Space = O(log n)
Worst case (skewed BST): h = O(n) → Space = O(n)
Average case (reasonably balanced): h = O(log n) → Space = O(log n)
*/
