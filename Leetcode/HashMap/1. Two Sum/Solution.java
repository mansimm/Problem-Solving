/*
Steps:
1.	We will maintain hashmap of (num[i], i) ie. Number and its location and ans arr of size 2
2.	Iterate over array using i and find val = target – nums[i]
3.	If val is present in map, set ans to i and map.get(val) and return ans
4.	If not present put (nums[i], i) in map
5.	In the end return ans arr (incase ans not found, empty arr will be return)
  */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        int res[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                res[0] = i;
                res[1] = map.get(val);
                return res;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
//Time c = O(n) and space c = O(n)
