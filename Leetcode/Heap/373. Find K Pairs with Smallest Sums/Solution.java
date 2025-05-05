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
