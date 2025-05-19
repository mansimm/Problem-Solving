class Solution {
    List<Integer> currentCombination = new ArrayList();
    List<List<Integer>> result = new ArrayList();
    int comboLen;
    int totalNumbers;

    public List<List<Integer>> combine(int n, int k) {
        this.comboLen = k;
        this.totalNumbers = n;
        backtrack(1);
        return result;
    }

    public void backtrack(int index){
        if(currentCombination.size()==comboLen){
            result.add(new ArrayList(currentCombination));
            return;
        }
        if(index>totalNumbers) return;
        currentCombination.add(index);
        backtrack(index+1);

        currentCombination.remove(currentCombination.size()-1);
        backtrack(index+1);
    }
}
