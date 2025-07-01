class Solution2 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
//Time o(n) and space O(h), better runtime than Solution1
