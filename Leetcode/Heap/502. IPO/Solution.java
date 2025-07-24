class Solution {
    record T(int profit, int capital){};
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<T> minHeap = new PriorityQueue(Comparator.comparing(T::capital));
        PriorityQueue<T> maxHeap = new PriorityQueue(Comparator.comparing(T::profit, Comparator.reverseOrder()));

        for(int i=0;i<profits.length;i++){
            minHeap.offer(new T(profits[i], capital[i]));
        }
        while(k>0){
            while(!minHeap.isEmpty() &&  minHeap.peek().capital<=w){
                maxHeap.offer(minHeap.poll());
            }
            if(maxHeap.isEmpty()){
                break;
            }
            w += maxHeap.poll().profit;
            k--;
        }
        return w;
    }
}
//Time c = O(nlogn), space c = O(n)
/*
Time Complexity Analysis
1.	Initialization: 
    o	Creating the min-heap and max-heap takes O(1) time (initial setup of empty heaps).
    o	The record T is a simple data structure with no additional overhead in terms of complexity.
2.	Filling the Min-Heap: 
    o	The loop for(int i=0; i<profits.length; i++) iterates over n projects (where n = profits.length).
    o	For each project, inserting into the min-heap (minHeap.offer) has a time complexity of O(logn).
    o	Total time for this step: O(nlogn).
3.	Main Loop: 
    o	The outer while(k>0) loop runs at most k times.
    o	Inside this loop, there’s an inner while loop: while(!minHeap.isEmpty() && minHeap.peek().capital<=w). 
    	In the worst case, this inner loop could process all n elements from the min-heap over the entire execution (each element is polled exactly once).
    	Each operation involves: 
    	peek():O(1).
    	poll() from min-heap: O(logn).
    	offer() to max-heap: O(logn).
    	Since each element is moved from the min-heap to the max-heap at most once, the total cost for all poll and offer operations across all iterations is O(nlogn).
    o	After the inner loop, the algorithm checks if the max-heap is empty (O(1)) and, if not, performs a poll() from the max-heap O(logn)).
    o	The poll() from the max-heap happens at most k times (since it’s tied to the outer loop).
    o	Total cost for max-heap poll operations: O(klogn).
4.	Overall Time Complexity: 
    o	Filling the min-heap: O(nlogn).
    o	Moving elements from min-heap to max-heap: O(nlogn).
    o	Polling from max-heap (up to k times): O(klogn).
    o	Combining these, the total time complexity is: O(nlogn+klogn)=O((n+k)logn) 
o	In the worst case, if k≈n k \approx n k≈n, this simplifies to O(nlogn), but we keep the general form as ((n+k)logn) to account for cases where k and n differ significantly.

Space Complexity Analysis
1.	Data Structures: 
    o	Min-Heap: Stores up to n elements (each element is a T record containing profit and capital).
    o	Max-Heap: In the worst case, all n elements could be moved to the max-heap if the capital requirement of all projects is less than or equal to w.
    o	Total space for both heaps: O(n) 
2.	Input Arrays: 
    o	The input arrays profits and capital are not modified and are considered part of the input, so they don’t count toward auxiliary space.
3.	Other Variables: 
    o	Variables like k, w, and loop counters use O(1) space.
4.	Overall Space Complexity: 
    o	The auxiliary space is dominated by the two heaps, so the total space complexity is: O(n) 

*/
