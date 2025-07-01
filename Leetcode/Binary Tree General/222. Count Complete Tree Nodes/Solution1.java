class Solution1 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            count++;
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
        return count;
    }
}
/*
Time Complexity: O(n)
Analysis:
Single traversal: Each node in the tree is visited exactly once
Constant work per node: At each node, we perform O(1) operations:
Pop from stack: O(1)
Increment counter: O(1)
Check and push children: O(1) each
Total operations: n nodes × O(1) per node = O(n)
Result: Linear time complexity where n is the total number of nodes
Space Complexity: O(h) where h is the height of the tree
Analysis:
Stack space: The stack stores nodes that are waiting to be processed
Maximum stack size: In the worst case, we might have all nodes at one level in the stack
Best case: O(log n) for a complete/balanced binary tree
Worst case: O(n) for a completely skewed tree
Average case: O(log n) for a complete binary tree (which this problem specifically targets)
This solution is slow
*/
