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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0){
            return null;
        }
        HashMap<Integer,Integer> inToIndex = new HashMap();
        for(int i=0;i<inorder.length;i++){
            inToIndex.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inToIndex);
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inToIndex){
        if(inStart>inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        int inIndex = inToIndex.get(rootVal);
        int leftSize = inIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, inIndex-1, postorder, postStart, postStart+leftSize-1, inToIndex);
        root.right = buildTree(inorder, inIndex+1, inEnd, postorder, postStart+leftSize, postEnd-1, inToIndex);
        return root;
    }
}
//Time c. O(n), space c.O(n)
