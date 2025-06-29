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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }else if(root.left!=null && root.right!=null){
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }else if(root.left!=null){
            return maxDepth(root.left)+1;
        }else{
            return maxDepth(root.right)+1;
        }
    }
}
/*
Time c O(n) and space complexity O(H)
🧠 Time Complexity: O(n)
•	Each node is visited exactly once.
•	At each node, a constant amount of work is done (checking left/right and doing a comparison).
•	So the total work is proportional to the number of nodes.
✅ Time = O(n) where n is the number of nodes in the tree.
________________________________________
🧠 Space Complexity
🔹 Recursive Stack Space
•	The maximum amount of space used on the call stack depends on the height of the tree:
o	Balanced tree: height = log(n) ⇒ space = O(log n)
o	Skewed tree (linked-list-like): height = n ⇒ space = O(n)
There is no additional memory used apart from recursion stack (no array, list, etc.).
✅ Space = O(h), where h is the height of the tree.
So in worst-case (skewed tree), space complexity = O(n)
In best-case (perfectly balanced tree), space complexity = O(log n)
*/
