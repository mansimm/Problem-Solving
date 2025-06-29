class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inToIndex = new HashMap();
        for(int i=0;i<inorder.length;i++){
            inToIndex.put(inorder[i],i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inToIndex);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
    int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> inToIndex){
        if(preStart>preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int inIndex = inToIndex.get(rootVal);
        int leftSize = inIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart+1, preStart+leftSize, inorder, inStart, inIndex-1, inToIndex);
        root.right = buildTree(preorder, preStart+leftSize+1, preEnd, inorder, inIndex+1, inEnd, inToIndex);
        return root;
    }
}
//Time O(n) and space O(n) , https://youtu.be/ihj4IQGZ2zc
