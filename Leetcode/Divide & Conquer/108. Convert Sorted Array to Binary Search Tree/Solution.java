/*
Logic:
•	Create a function buildTree and pass start and end as 0 and arr.len-1 respectively
•	Find the mid element from sorted array and create root node from this value
•	Recursively call same function on left of mid and assign it to root.left
•	Recursively call same function on right of mid and assign it to root.right
*/
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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return buildTree(0, nums.length-1);
    }
    public TreeNode buildTree(int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(start, mid-1);
        node.right = buildTree(mid+1, end);
        return node;
    }
}
