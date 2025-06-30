class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode current = stack.peek();
            stack.pop();
            if(current.right!=null){
                stack.push(current.right);
            }
            if(current.left!=null){
                stack.push(current.left);
            }
            if(!stack.isEmpty()){
                current.right = stack.peek();
            }
            current.left = null;
        }
    }
}
/*
Time Complexity:
1.The algorithm uses a while loop that runs until the stack is empty.
2.Each node is pushed onto the stack exactly once.
3.Each node is popped from the stack exactly once.
4.For each node, we perform constant time operations (checking and pushing left and right children, setting left to null, and setting right to the next node).
Therefore, the time complexity is O(N), where N is the number of nodes in the binary tree. Each node is processed once, and all operations for each node are constant time.
Space Complexity:
1.The space complexity is determined by the maximum size of the stack.
2.In the worst case, the stack could contain all the nodes of one level of the tree.
3.For a balanced tree, the maximum number of nodes at any level is N/2 (at the leaf level).
4.For a completely unbalanced tree (like a linked list), the stack would never contain more than 2 nodes at a time.
Therefore, the space complexity is O(W), where W is the maximum width of the tree.
In the worst case (for a balanced tree): O(N/2), which simplifies to O(N)
In the best case (for a completely unbalanced tree): O(1)
For an average binary tree: O(log N), as the maximum width is typically at the leaf level
This iterative solution uses explicit extra space (the stack) unlike the recursive solution which used implicit stack space. However, it has the advantage of avoiding potential stack overflow for very deep trees.
*/
