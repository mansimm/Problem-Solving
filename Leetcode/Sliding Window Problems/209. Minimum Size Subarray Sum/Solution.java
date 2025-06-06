/*
Steps:
1.	Assign start=0, end=0 and sum=0, window=Integer.max_value
2.	Start iterating over end till n, add each arr[end] to sum (We will calculate the sum from start to end)
3.	In inner loop, check if sum is greater than equal to target
4.	if it is we will update window to Math.min(window, j-i+1) we will drop start from sum (sum – arr[start]) and Start++ and repeat 3 and 4
5.	else we will move to next loop ie. End++
6.	if sum is Integer.max_value then will return 0(sum didn’t got greater than or equal to target else return window
*/
  class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int window = Integer.MAX_VALUE;

        for(end=0;end<nums.length;end++){
            sum += nums[end];
            while(sum>=target){
                window = Math.min(window, end-start+1);
                sum -= nums[start];
                start++;
            }
        }
        return (window == Integer.MAX_VALUE) ? 0:window;
    }
}
//Time c. = O(n), space c = O(1)
