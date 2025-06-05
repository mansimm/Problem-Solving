// Steps:
// 1.	Take 2 pointers i=0 and j=arr.len-1
// 2.	For each I and j check if sum is equal to target if it is return index i+1 and j+1
// 3.	Else if sum > target then j--(as array is sorted)
// 4.	Else i++
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum == target){
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
}
//Time complexity O(n) and space complexity O(1)
