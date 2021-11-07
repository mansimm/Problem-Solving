class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList();
        List<Integer> temp = new ArrayList();
        recPermute(ans,temp,nums);
        return ans;
    }
    public void recPermute(List<List<Integer>> ans,List<Integer> temp,int[] nums)
    {
        if(temp.size()==nums.length)
        {
            ans.add(new ArrayList(temp));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(temp.contains(nums[i]))
            {
                continue;
            }
            else
            {
                temp.add(nums[i]);
                recPermute(ans,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
