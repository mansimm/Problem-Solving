•	/**
•	 * Definition for a binary tree node.
•	 * public class TreeNode {
•	 *     int val;
•	 *     TreeNode left;
•	 *     TreeNode right;
•	 *     TreeNode() {}
•	 *     TreeNode(int val) { this.val = val; }
•	 *     TreeNode(int val, TreeNode left, TreeNode right) {
•	 *         this.val = val;
•	 *         this.left = left;
•	 *         this.right = right;
•	 *     }
•	 * }
•	 */
	class Solution {
	    public boolean isValidBST(TreeNode root) {
	        return validate(root, null, null);
	    }
	    public boolean validate(TreeNode root, TreeNode left, TreeNode right){
	        if(root==null){
	            return true;
	        }
	        if(left!=null && !(root.val>left.val)){
	            return false;
	        }
	        if(right!=null && !(root.val<right.val)){
	            return false;
	        }
	        return (validate(root.left, left, root) && validate(root.right, root, right));
	    }
	}
/*
https://youtu.be/s6ATEkipzow
Core Concept
The solution uses range-based validation with recursive bounds checking. Instead of just comparing a node with its immediate children, it maintains the valid range (bounds) that each node's value must fall within.
How It Works
Main Method
public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
}
Starts validation with no initial bounds (null for both left and right bounds)
null means "no constraint" initially
Validation Logic
public boolean validate(TreeNode root, TreeNode left, TreeNode right)
Parameters:
root: Current node being validated
left: Lower bound node (current node must be > left.val)
right: Upper bound node (current node must be < right.val)
Step-by-Step Process
1.Base Case:
if(root==null) return true;
Empty subtrees are valid BSTs
2.Lower Bound Check:
if(left!=null && !(root.val>left.val)) return false;
If there's a lower bound, current node must be strictly greater
Ensures no duplicate values and maintains BST property
3.Upper Bound Check:
if(right!=null && !(root.val<right.val)) return false;
If there's an upper bound, current node must be strictly less
Prevents violations of BST ordering
4.Recursive Validation:
return (validate(root.left, left, root) && validate(root.right, root, right));
Left subtree: Keep same lower bound, but current node becomes new upper bound
Right subtree: Current node becomes new lower bound, keep same upper bound
Example Walkthrough
Consider this tree:
    5
   / \
  3   8
 / \ / \
1  4 7  9
Validation trace:
1.validate(5, null, null) - No bounds, 5 is valid
2.validate(3, null, 5) - 3 must be < 5 ✓
3.validate(8, 5, null) - 8 must be > 5 ✓
4.validate(1, null, 3) - 1 must be < 3 ✓
5.validate(4, 3, 5) - 4 must be > 3 AND < 5 ✓
6.validate(7, 5, 8) - 7 must be > 5 AND < 8 ✓
7.validate(9, 8, null) - 9 must be > 8 ✓
Why This Works Better Than Naive Approaches
Problem with naive approach:
    10
   /  \
  5   15
     /  \
    6   20
Node 6 is < its parent 15, but violates BST property (should be > 10)
Simple parent-child comparison would miss this
This solution catches it:
When validating node 6: validate(6, 10, 15)
Check: 6 > 10? False! → Invalid BST
Complexity Analysis
Time: O(n) - visits each node once
Space: O(h) - recursive call stack depth, where h is tree height
This solution elegantly handles all edge cases and maintains the global BST property through local bound checking.
*/
