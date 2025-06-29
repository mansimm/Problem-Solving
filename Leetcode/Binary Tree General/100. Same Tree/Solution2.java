class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==q;
        }
        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
/*
🧠 Time Complexity: O(n)
•	The function visits each node exactly once in both trees (as long as structure and values match).
•	In the worst case (trees are identical), all nodes are visited.
✅ Time = O(n) where n is the number of nodes in the smaller of the two trees (assuming both are the same size, it's just n).
________________________________________
🧠 Space Complexity: O(h)
•	The recursion uses stack space proportional to the height of the tree:
o	Best case (balanced tree): height = log n ⇒ O(log n)
o	Worst case (completely unbalanced/skewed tree): height = n ⇒ O(n)
•	No other data structures are used.
✅ Space = O(h) where h is the height of the tree.
*/
