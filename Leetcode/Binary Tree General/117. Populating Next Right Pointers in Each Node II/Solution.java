//Hint: Use queue, FIFO
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()){//each level
            int size = que.size();
            Node dummy = new Node(0);
            while(size>0){//all node per level processed here
                Node temp = que.remove();
                dummy.next = temp;
                dummy = dummy.next;
                size--;
                if(temp.left!=null){
                    que.add(temp.left);
                }
                if(temp.right!=null){
                    que.add(temp.right);
                }
            }
        }
        return root;
    }
}
//Time c O(n), space c O(n) since using queue.
