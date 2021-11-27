class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1;
        int cnt = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                cnt++;
            }
            else
            {
                product *= nums[i];
            }
        }
        if(cnt>=2)
        {
            return new int[nums.length];
        }
        //System.out.println(product);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0 && cnt==0)
                nums[i] = product/nums[i];
            else if(nums[i]!=0 && cnt==1)
                nums[i] = 0;
            else
                nums[i]=product;
        }
        return nums;
    }
}
