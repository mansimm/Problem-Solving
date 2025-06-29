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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(q==null || p==null){
            return false;
        }else{
            if(isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right) &&
            p.val==q.val){
                return true;
            }else{
                return false;
            }
        }
    }
}
//Time O(n) space O(H).
