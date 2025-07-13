//Solution 2: Better runtime 
/*
Steps:
1.	Create hashmap to store digitToString mapping, arraylist result to store result
2.	Create a helper function which takes 3 params, digits, stringbuilder path, index of current digit
3.	In helper first check if path.length==digits.length if yes add path.toSTring in result
4.	Else fetch current digit at index, and append it to path
5.	Call helper(digits, path, index+1)
6.	And backtrack by removing last letter from path 
*/
class Solution2 {
    Map<Character, String> digitToString = new HashMap();
    List<String> result = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.isEmpty()){
            return result;
        }

        digitToString.put('2', "abc");
        digitToString.put('3', "def");
        digitToString.put('4', "ghi");
        digitToString.put('5', "jkl");
        digitToString.put('6', "mno");
        digitToString.put('7', "pqrs");
        digitToString.put('8', "tuv");
        digitToString.put('9', "wxyz");

        helper(digits, new StringBuilder(), 0);
        return result;
    }

    public void helper(String digits, StringBuilder path, int index){
        if(path.length()==digits.length()){
            result.add(path.toString());
            return;
        }
        String possibleStr = digitToString.get(digits.charAt(index));
        for(char str:possibleStr.toCharArray()){
            path.append(str);
            helper(digits, path, index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
/*
Time Complexity: O(4^n × n)
Breakdown:
n = length of input digits string
4 = maximum number of letters per digit (digits 7 and 9 have 4 letters)
Detailed Analysis:
1.Recursive calls structure:
    Each digit can have up to 4 possible letters
    We explore all combinations through backtracking
    Total combinations generated: up to 4^n
2.Work per combination:
    path.toString(): O(n) - converts StringBuilder to String
    path.append(str): O(1) amortized
    path.deleteCharAt(): O(1) 
    digits.charAt(index): O(1)
3.Total recursive calls: O(4^n)
4.Work per leaf node: O(n) for string conversion
    Total: O(4^n) combinations × O(n) string conversion = O(4^n × n)
    
Space Complexity: O(n)
Space Usage:
1.Recursion call stack:
    Maximum depth: n (one call per digit)
    Each call frame: O(1) space
    Stack space: O(n)
2.StringBuilder path:
    Maximum length: n characters
    Space: O(n)
3.HashMap digitToString:
    Fixed size (8 entries)
    Space: O(1)
4.Result list:
    Contains up to 4^n strings, each of length n
    Space: O(4^n × n)
    Note: This is output space, often not counted in auxiliary space analysis
    Auxiliary Space (excluding output): O(n) Total Space (including output): O(4^n × n)

*/
