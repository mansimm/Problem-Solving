class Solution {
    public int majorityElement(int[] nums) {
        
        int majourity = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majourity){
                cnt++;
            }else{
                cnt--;
                if(cnt==0){
                    majourity = nums[i];
                    cnt = 1;
                }
            }
        }
        return majourity;
    }
}
