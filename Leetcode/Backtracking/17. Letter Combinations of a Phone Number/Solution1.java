class Solution1 {
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
/*
Time Complexity: O(4^n × n)
Breakdown:
n = length of input digits string
4 = maximum number of letters per digit (digits 7 and 9 have 4 letters: "pqrs", "wxyz")
Detailed Analysis:
1.Outer loop: Runs n times (for each digit)
2.Inner nested loops: 
First inner loop: Iterates through current combinations in ans
Second inner loop: Iterates through letters of current digit (up to 4 letters)
3.Growth pattern:
After digit 1: up to 4 combinations
After digit 2: up to 4 × 4 = 16 combinations 
After digit 3: up to 4 × 4 × 4 = 64 combinations
After digit n: up to 4^n combinations
4.String concatenation: combo + c takes O(length of combo) time
Average string length grows to n/2, so O(n) per concatenation
Total: O(4^n) combinations × O(n) string operations = O(4^n × n)
Space Complexity: O(4^n × n)
Space Usage:
1.Result storage (`ans` and `temp` lists):
Maximum combinations: 4^n
Each combination string length: n characters
Space: O(4^n × n)
2.Input processing:
digits.toCharArray(): O(n)
combination array: O(1) - constant size
3.Temporary variables: O(n) for string concatenation
Dominant factor: O(4^n × n) for storing all combinations
Optimization Notes:
1.String concatenation: Could use StringBuilder for better performance
2.Memory usage: The algorithm creates new lists at each step, doubling memory usage temporarily
3.Alternative approach: Recursive backtracking might be more memory-efficient

*/
