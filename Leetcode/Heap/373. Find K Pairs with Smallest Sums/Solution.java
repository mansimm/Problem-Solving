class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        record T(int i, int j, int sum){};
        List<List<Integer>> ans = new ArrayList(); 
        Queue<T> minHeap = new PriorityQueue(Comparator.comparingInt(T::sum));
        int initialSize = Math.min(nums1.length, k);
        for(int i=0; i<initialSize;i++){
            minHeap.offer(new T(i, 0, nums1[i]+nums2[0]));
        } 
        while(!minHeap.isEmpty() && ans.size()!=k){
            int i = minHeap.peek().i;
            int j = minHeap.poll().j;
            List<Integer> temp = new ArrayList();
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            ans.add(temp);
            if(j+1<nums2.length){
                minHeap.offer(new T(i, j+1, nums1[i]+nums2[j+1]));
            }
        }
        return ans;
    }
}
//Time c = O(klogk), space c = O(k)
/*
Time Complexity Analysis
1.	Initialization: 
    o	The min-heap is initialized with pairs (i, 0) for i from 0 to initialSize - 1, where initialSize = min(nums1.length, k).
    o	Let m = nums1.length, n = nums2.length, and initialSize = min(m, k).
    o	Inserting each pair into the min-heap takes O(log(initialSize)).
    o	Total time for initialization: O(initialSize⋅log(initialSize)), which is O(min(m,k)⋅log(min(m,k))).
2.	Main Loop: 
    o	The loop runs until k pairs are added to ans or the heap is empty: while(!minHeap.isEmpty() && ans.size()!=k).
    o	In the worst case, the loop executes k times (if the heap has enough pairs).
    o	Each iteration involves: 
        	peek(): O(1) 
        	poll():O(logh), where h is the current heap size (at most min(m, k) initially, and it may grow slightly as new pairs are added).
        	Creating a new ArrayList and adding two integers: O(1).
        	Adding the list to ans: O(1).
        	If j+1 < nums2.length, inserting a new pair (i, j+1) into the heap: O(logh).
    o	Each iteration performs at most one poll and one offer, each costing O(logh), where h \leq min(m, k) (since the heap size never exceeds min(m, k) significantly).
    o	Total cost for k iterations: O(k⋅log(min(m,k))).
3.	Overall Time Complexity: 
    o	Initialization: O(min(m,k)⋅log(min(m,k))).
    o	Main loop: O(k⋅log(min(m,k))).
    o	Combining: O(min(m,k)⋅log(min(m,k))+k⋅log(min(m,k))).
    o	Since min(m,k)≤k, the dominant term is: O(k⋅log(min(m,k))) 
    o	This accounts for both the initialization and the loop, as the initialization cost is subsumed when k≥min(m,k).

Space Complexity Analysis
1.	Data Structures: 
    o	Min-Heap: Initially stores min(m, k) pairs. Throughout execution, the heap size remains bounded by min(m, k) because for each poll, at most one new pair is added. Each pair (record T) stores three integers (i, j, sum). Space: (min(m,k)).
    o	Output List (ans): Stores up to k pairs, where each pair is an ArrayList containing two integers. Space: O(k).
    o	Temporary List (temp): A single ArrayList reused in each iteration, holding two integers. Space: O(1).
2.	Input Arrays: 
    o	nums1 and nums2 are input and not counted toward auxiliary space.
3.	Overall Space Complexity: 
    o	Heap: O(min(m,k)).
    o	Output: O(k).
    o	Total auxiliary space (excluding output, if we consider only extra space): O(min(m,k)).
    o	If the output space is included (as is typical when the output is part of the space analysis): O(k+min(m,k))=O(k), since min(m,k)≤k.

*/
