	class Solution {
	    public List<String> summaryRanges(int[] nums) {
	        List<String> ans = new ArrayList();
	        for(int i=0;i<nums.length;i++){
	            int start = nums[i];
	            while(i+1<nums.length && nums[i]+1==nums[i+1]){
	                i++;
	            }
	            String s = ""+start;
	            if(nums[i]!=start){
	                s+="->"+nums[i];
	            }
	            ans.add(s);
	        }
	        return ans;
	    }
	}
//Time c = O(n) as we are visiting elements of arr once event with 2 loops and space c. = O(1) if we don’t consider the output list
