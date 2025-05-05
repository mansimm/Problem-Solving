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
//Time c = O(nlogn) and space O(n)
