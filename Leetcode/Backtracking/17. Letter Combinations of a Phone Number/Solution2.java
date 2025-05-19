//Solution 2: Better runtime 
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
