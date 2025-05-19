class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList();
        if(digits==null || digits.isEmpty()){
            return ans;
        }
        ans.add("");
        String[] combination = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        for(char digit: digits.toCharArray()){
            int idx = digit-'2';
            String str = combination[idx];
            List<String> temp = new ArrayList();
            for(String combo: ans){
                for(char c: str.toCharArray()){
                    String s = combo+c;
                    temp.add(s);
                }
            }
            ans = temp;
        }
        return ans;
    }
}
