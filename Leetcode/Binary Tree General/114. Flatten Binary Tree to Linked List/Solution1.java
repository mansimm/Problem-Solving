// https://youtu.be/sWf7k1x9XR4
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        //we are traversing tree in reverse preorder
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
/*
Let's analyze the time and space complexity of the given solution:
Time Complexity:
1. The function `flatten` is called recursively for each node in the binary tree.
2. Each node is visited exactly once.
3. The operations performed for each node (assigning right child, setting left child to null, and updating prev) are constant time operations.
Therefore, the time complexity is O(N), where N is the number of nodes in the binary tree.

Space Complexity:
1. The space complexity is determined by the maximum depth of the recursion stack.
2. In the worst case (a completely unbalanced tree), the recursion depth could be equal to the number of nodes in the tree.
3. However, for a balanced tree, the depth would be log(N).
4. The algorithm uses only a constant amount of extra space (the `prev` variable) apart from the recursion stack.

Therefore, the space complexity is O(H), where H is the height of the tree.
- In the worst case (completely unbalanced tree): O(N)
- In the best and average case (balanced tree): O(log N)

It's worth noting that this is an in-place algorithm, meaning it doesn't use any additional data structures proportional to the input size. The only extra space used is the implicit stack space due to recursion.
*/
