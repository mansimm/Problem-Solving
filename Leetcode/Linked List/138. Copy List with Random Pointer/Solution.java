/*
Steps:
1.	create a dummy node and current node pointing to dummy
2.	then initialize pointer temp pointing to head
3.	create a hashmap to store node form original list and its new deep copied node
4.	iterate on main list and create newNode with matching value, set temp = temp.next, current.next=newNode
5.	after this set temp=head and current=dummy.next
6.	iterate again on temp, for each temp node fetch temp.random in randomOrg, and for this randomOrg fetch corresponding deep copied node from map in randomCp, assign it to currents.random
7.	return dummy.next
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node current = dummy;
        HashMap<Node, Node> map = new HashMap();
	// map store nodes from original list as key and corresponding new deep copied node as val
        Node temp = head;
        while(temp!=null){
            Node node = new Node(temp.val);
            current.next = node;
            map.put(temp,node);
            current = current.next;
            temp = temp.next;
        }
        temp=head;
        current=dummy.next;

        while(temp!=null){
            Node randomOrg = temp.random;
            Node randomCp = map.get(randomOrg);
            current.random = randomCp;
            temp = temp.next;
            current = current.next;
        }        
        return dummy.next;
    }
}
//Time c O(n), space c O(n)
