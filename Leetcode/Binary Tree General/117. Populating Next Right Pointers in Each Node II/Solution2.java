class Solution2 {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node head = root;
        while(head!=null){
            Node dummy = new Node(0);
            Node temp = dummy;
            while(head!=null){
                if(head.left!=null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right!=null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}
//Time c O(n) and space O(1)
