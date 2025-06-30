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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null && targetSum==0){
            return false;
        }
        if(root==null && targetSum!=0){
            return false;
        }
        int rem = targetSum-root.val;
        if(root.left==null && root.right==null && rem == 0){
            return true;
        }
        boolean left = hasPathSum(root.left, rem);
        boolean right = hasPathSum(root.right, rem);
        return (left || right);
    }
}
/*
Let's analyze the time and space complexity of this recursive solution for the "Path Sum" problem:

Time Complexity:
1. The function `hasPathSum` is called recursively for each node in the binary tree.
2. In the worst case, we might have to visit all nodes of the tree.
3. For each node, we perform constant time operations (value comparisons and arithmetic).
Therefore, the time complexity is O(N), where N is the number of nodes in the binary tree. We visit each node once, and the operations at each node are constant time.

Space Complexity:
1. The space complexity is determined by the maximum depth of the recursion stack.
2. In the worst case (a completely unbalanced tree, essentially a linked list), the recursion depth could be equal to the number of nodes in the tree.
3. For a balanced tree, the depth would be log(N).
4. The algorithm doesn't use any additional data structures that grow with the input size.

Therefore, the space complexity is O(H), where H is the height of the tree.
- In the worst case (completely unbalanced tree): O(N)
- In the best and average case (balanced tree): O(log N)

It's important to note that this space complexity is due to the implicit stack space used by recursion. The algorithm itself doesn't use any extra space that grows with the input size.

Additional notes:
1. The solution correctly handles the edge cases (null root node).
2. It efficiently checks for the path sum by subtracting node values from the target sum as it traverses down the tree.
3. The solution returns true as soon as it finds a valid path, which can be more efficient in some cases than checking all paths.
*/
