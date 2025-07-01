class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode temp = stack.pop();
        int data = temp.val;
        temp = temp.right;
        while(temp!=null){
            stack.push(temp);
            temp=temp.left;
        }
        return data;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
/*
✅ Space Complexity:
The space is used mainly by the stack, which stores nodes temporarily.

In the worst case, the stack contains all the leftmost nodes of the BST.

For a balanced BST, the height is O(log n), and the stack will store at most O(log n) nodes.

For a skewed BST (e.g., every node only has a left child), the stack can grow up to O(n).

➤ Space complexity:
O(h), where h is the height of the tree.

Worst case: O(n) (skewed tree)

Average case (balanced tree): O(log n)

✅ Time Complexity:
1. Constructor (BSTIterator(TreeNode root))
Traverses from the root to the leftmost node and pushes each node onto the stack.

In the worst case, this is O(h) operations.

2. next()
Pops the top node from the stack — O(1)

Then pushes all leftmost nodes from the right child of that node — this can take up to O(h) time.

However, amortized time complexity for next() is O(1) over n calls:

Every node is pushed and popped from the stack once.

So over n calls to next(), total time is O(n) ⇒ amortized O(1).

3. hasNext()
Just checks if the stack is empty — O(1)
*/
