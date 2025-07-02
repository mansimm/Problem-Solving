class Solution1 {
    List<Integer> inorder = new LinkedList();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return inorder.get(k-1);
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
}
/*
🕒 Time Complexity
•	Inorder Traversal: Visits every node in the BST exactly once.
o	If there are nnn nodes in the tree, the traversal takes O(n) time.
•	Retrieving kthk^{th}kth element from list: inorder.get(k-1) takes O(k) for a LinkedList (since it's not random access). But if you used an ArrayList, it would be O(1).
✅ Overall Time Complexity:
•	With LinkedList: O(n + k)
•	With ArrayList: O(n)
________________________________________
📦 Space Complexity
•	Inorder List: Stores all nnn node values → O(n) space.
•	Call Stack: The recursion stack can go as deep as the height of the tree hhh.
o	In worst case (unbalanced tree): h=nh = nh=n
o	In best case (balanced tree): h=log⁡nh = \log nh=logn
✅ Overall Space Complexity:
•	Worst case: O(n) (inorder list + recursion stack)
•	Best case: O(n) (inorder list + O(log n) recursion)
*/
