class LRUCache {
    private int capacity;
    private Set<Node> cache = new LinkedHashSet();
    private Map<Integer, Node> keyToNode = new HashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)){
            return -1;
        }
        Node node = keyToNode.get(key);
        //since this node is accessed recently update cache and delete, add it again at the end of set
        cache.remove(node);//remove from start
        cache.add(node);//add at the end - most recent
        return node.value;
    }
    
    public void put(int key, int value) {
        if(keyToNode.containsKey(key)){
            keyToNode.get(key).value = value;
            get(key);//will update cache
            return;
        }
        if(capacity == keyToNode.size()){
            //delete least recently accessed node, ie  first in set
            Node node = cache.iterator().next();
            cache.remove(node);
            keyToNode.remove(node.key);
        }
        Node node = new Node(key, value);
        keyToNode.put(key, node);
        cache.add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 class Node{
    int key;
    int value;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
 }
//•	Time: get(key: int),, put(key: int, value: int): O(1)O(1)
//•	Space: O(capacity)O(capacity)
