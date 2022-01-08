class Solution {
    int maxLength = 0;
    public int arrayNesting(int[] nums) {
      
        boolean visited[] = new boolean[nums.length];
        int cnt = 0;
        for(int i=0;i<nums.length;i++)
        {
            dfs(nums,visited,i,cnt);
        }
        return maxLength;
    }
    public void dfs(int nums[], boolean visited[],int i, int cnt)
    {
        if(visited[i])
        {
            if(cnt>maxLength)
            {
                maxLength = cnt;
            }
            return;
        }
        else
        {
            visited[i]=true;
            cnt++;
            dfs(nums,visited,nums[i],cnt);
        }
    }
}
