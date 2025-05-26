class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private Random random = new Random();
    private int size = 0;
    public RandomizedSet() {
        map = new HashMap();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, 1);
        size++;
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        map.remove(val);
        size--;
        return true;
    }
    
    public int getRandom() {
        int idx = random.nextInt(size);
        Iterator<Integer> it = map.keySet().iterator();
        int i =0;
        while(i!=idx){
            it.next();
            i++;
        }
        return it.next();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//each function works in average O(1) time complexity
//space complexity O(n)
