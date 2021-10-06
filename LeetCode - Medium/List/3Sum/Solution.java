class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++)
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1]))
            {
                int low = i+1,hi=nums.length-1;
                int sum = 0;
                
                while(low<hi)
                {
                    sum=nums[low]+nums[hi]+nums[i];
                    if(sum>0)
                    {
                        hi--;
                    }
                    else if(sum<0)
                    {
                        low++;
                    }
                    else
                    {
                        ans.add(Arrays.asList(nums[i],nums[low],nums[hi]));
                        low+=1;
                        while(nums[low]==nums[low-1]&&low<hi)
                        {
                            low+=1;
                        }
                    }
                }
                
            }
        }
        
        //below code works but exceed time limit
        /*
        if(nums.length==0)
        {
            return ans;
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                for(int k=0;k<nums.length;k++)
                {
                    if(i!=j && i!=k && j!=k)
                    {
                        if(nums[i]+nums[j]+nums[k]==0)
                        {
                            List<Integer> x = new ArrayList<>();
                            x.add(nums[i]);
                            x.add(nums[j]);
                            x.add(nums[k]);
                            int flag = 0;
                            //System.out.println(x);
                            for(List<Integer> z:ans)
                            {
                                if(x.containsAll(z)&&z.containsAll(x))
                                {
                                    // if(x.equals(List.of(0,0,0)))
                                    // {
                                     //    System.out.println("x : "+x+" z : "+z);
                                    // }
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0)
                            {
                                ans.add(x);
                            }
                        }
                    }
                }
            }
        }*/
        return ans;
    }
}
