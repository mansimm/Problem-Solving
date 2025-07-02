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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        if(root==null){
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
            if(ans.size()%2!=0){
                Collections.reverse(res);
            }
            ans.add(res);
        }
        return ans;
    }
}

//Time Complexity: O(N)
//Space Complexity: O(W), where W is the maximum width of the tree (best case O(1), worst case O(N))
