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
