class Solution1 {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int n: nums){
            ones = (ones^n) & (~twos);
            twos = (twos^n) & (~ones);
        }
        return ones;
    }
}
//Time c = O(n) , space O(1)
