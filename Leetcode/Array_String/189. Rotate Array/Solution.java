class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==1){
            return;
        }
        k = k % nums.length;
        //step 1: reverse arr
        reverse(nums, 0, nums.length-1);
        //step 2: reverse first k elements
        reverse(nums, 0, k-1);
        //step 3: reverse remaining elements
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int l, int r){
        int temp = 0;
        for(int i=l,j=r; i<j; i++,j--){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
