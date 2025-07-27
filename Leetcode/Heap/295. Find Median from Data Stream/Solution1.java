	class MedianFinder {
	    Queue<Integer> minHeap = null;
	    Queue<Integer> maxHeap = null;
	    public MedianFinder() {
	        minHeap = new PriorityQueue();
	        maxHeap = new PriorityQueue(Comparator.reverseOrder());
	    }
	    
	    public void addNum(int num) {
	        if(maxHeap.size()==0 || num<=maxHeap.peek()){
	            maxHeap.offer(num);
	        }else{
	            minHeap.offer(num);
	        }
	        if(maxHeap.size()<minHeap.size()){
	            maxHeap.offer(minHeap.poll());
	        }else if(maxHeap.size()-minHeap.size()>1){
	            minHeap.offer(maxHeap.poll());
	        }
	    }
	    
	    public double findMedian() {
	        if(maxHeap.size()==minHeap.size()){
	            return (maxHeap.peek()+minHeap.peek())/2.0;
	        }
	        return maxHeap.peek();
	    }
	}
	
	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */
/*
🔍 Overview of the Code:
•	The class maintains two heaps:
o	maxHeap: stores the smaller half of numbers (as a max-heap using PriorityQueue with reversed comparator).
o	minHeap: stores the larger half of numbers (as a min-heap using PriorityQueue).
This setup allows efficient median tracking as numbers are added.
________________________________________
✅ Time Complexity
addNum(int num):
•	Insertion into a heap: O(log n) (either into maxHeap or minHeap).
•	Rebalancing: May involve at most one poll and one offer for each heap → still O(log n).
✔️ Overall: O(log n) per addNum.
findMedian():
•	Just peek operations, which are O(1).
✔️ Overall: O(1) for findMedian.
________________________________________
✅ Space Complexity
You're storing all inserted elements in either maxHeap or minHeap. Each number is stored once in one of the heaps.
✔️ Total space: O(n), where n is the number of elements added.
*/
