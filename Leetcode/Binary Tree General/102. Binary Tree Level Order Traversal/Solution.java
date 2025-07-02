class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> res = new LinkedList();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                res.add(node.val);
            }
            ans.add(res);
        }
        return ans;
    }
}
/*
Time Complexity: O(N)
The algorithm visits each node in the tree exactly once
the space complexity is O(W), where W is the maximum width of the binary tree.
In the best case (skewed tree), W = 1, so space complexity would be O(1).
In the worst case (perfect binary tree), the last level could contain up to N/2 nodes, so W = N/2, and space complexity would be O(N).
*/
