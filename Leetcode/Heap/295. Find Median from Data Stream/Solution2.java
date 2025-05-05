class MedianFinder {
    Queue<Integer> leftHalf = new PriorityQueue(Comparator.reverseOrder());//max heap
    Queue<Integer> rightHalf = new PriorityQueue();//min heap

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(leftHalf.size()==0){
            leftHalf.add(num);
        }else if(leftHalf.size()==rightHalf.size()){
            if(num>rightHalf.peek()){
                leftHalf.offer(rightHalf.poll());
                rightHalf.offer(num);
            }else{
                leftHalf.offer(num);
            }
        }else{
            if(num<leftHalf.peek()){
                rightHalf.offer(leftHalf.poll());
                leftHalf.offer(num);
            }else{
                rightHalf.offer(num);
            }
        }  
    }
    
    public double findMedian() {
        if(leftHalf.size()==rightHalf.size()){
            return (leftHalf.peek()+rightHalf.peek())/2.0;
        }
        return leftHalf.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// Time Complexity: 
// Per operation: O(log n) for addNum(), O(1) for findMedian()
// For n operations: O(n log n)
// Space Complexity: O(n)
