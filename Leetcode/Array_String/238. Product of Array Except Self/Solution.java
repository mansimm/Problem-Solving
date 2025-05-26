class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int zeros = 0;
        int product = 1;
        int idx = -1;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeros++;
                idx = i;
            }else{
                product = product * nums[i];
            }
        }
        if(zeros == 0){
            for(int i=0;i<n;i++){
                answer[i] = product/nums[i];
            }
        }
        else if(zeros == 1){
            answer[idx] = product;
        }
        // if zeros are more than 1 then all the elements will be zero so, array will be returned as is
        return answer;
    }
}
//Time c = O(n), space c = O(1)
