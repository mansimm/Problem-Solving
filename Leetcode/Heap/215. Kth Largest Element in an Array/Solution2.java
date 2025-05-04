class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue();
        for(int n: nums){
            que.offer(n);
            if(que.size()>k){
                que.poll();
            }
        }
        return que.poll();
    }
}
//Time c = O(nlogk) and space c = O(k)
