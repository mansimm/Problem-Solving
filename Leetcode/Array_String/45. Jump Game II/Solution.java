class Solution {
    public int jump(int[] nums) {
        int destination = nums.length - 1 ;
        int totalJumps = 0;
        int coverage = 0;
        int lastIndex = 0;

        //base case
        if(nums.length==0){
            return 0;
        }
        //greedy startegy: cover maximum coverage(max jump distance) possible
        for(int i=0; i<nums.length-1; i++){
            coverage = Math.max(coverage, i + nums[i]);
            if(i == lastIndex){
                lastIndex = coverage;
                totalJumps++;
                if(lastIndex == destination){
                    return totalJumps;
                }
            }
        }
        return totalJumps;
    }
}
//Time C= O(n), space c = O(1)
