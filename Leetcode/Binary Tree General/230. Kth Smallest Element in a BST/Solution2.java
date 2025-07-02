class Solution2 {
    int count = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }
    public void inorder(TreeNode root, int k){
        if(root==null){
            return;
        }
        inorder(root.left, k);
        count++;
        if(count==k){
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
/*
🕒 Time Complexity
•	In the worst case, we may need to traverse all n nodes, especially when:
o	The tree is unbalanced, and k is near n (e.g., k = n)
o	The desired node is the last visited in inorder
✅ Worst-case time: O(n)
•	In the best case, we find the k-th smallest element early (e.g., k = 1), and the tree is balanced.
✅ Best-case time: O(k)
________________________________________
📦 Space Complexity
1. Recursion Stack:
•	The depth of the recursion stack is equal to the height of the tree:
o	Balanced BST → height = O(log n)
o	Skewed BST → height = O(n)
2. Other Space:
•	No auxiliary data structures (like a list or stack) are used.
•	Only a few variables: count, res → O(1)
✅ Space Complexity:
•	Balanced tree: O(log n)
•	Worst case (skewed): O(n)
*/
