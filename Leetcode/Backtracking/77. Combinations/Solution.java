/*
Steps:
1.	Create list currentCombination to store current combo and List<List> to store result
2.	Assign combolen and totalnumbers with k and n respectively, call backtrack(1)
3.	In backtrack first check if currentCombination.length==n, if yes add it to result and return
4.	If index is greater than totalNumber return 
5.	Else add the index in currentCombination and call backtrack(index+1)
6.	Remove last element from currentCombination
7.	Again call backtrack(index+1)
*/
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
/*
Time Complexity: O(C(n,k) × k)
Breakdown:
1.Total combinations generated: C(n,k) = n!/(k!(n-k)!)
    This is the mathematical number of ways to choose k items from n items
2.Work per combination:
    When currentCombination.size() == comboLen, we execute:
    new ArrayList(currentCombination): O(k) - copies k elements
    result.add(...): O(1) - adds to result list
3.Total recursive calls:
    The algorithm explores a binary decision tree
    Each number has 2 choices: include or exclude
    Maximum depth: n levels
    Total nodes in decision tree: O(2^n)
    However, many branches are pruned early
4.Actual work done:
    Only C(n,k) branches reach the base case and do meaningful work
    Each successful branch does O(k) work for copying
    Total: C(n,k) × k
    Examples:
    combine(4, 2): C(4,2) × 2 = 6 × 2 = 12 operations
    combine(5, 3): C(5,3) × 3 = 10 × 3 = 30 operations
    
Space Complexity: O(k)
Auxiliary Space Analysis:
1.Recursion call stack:
    Maximum depth: n (when we keep including numbers 1,2,3...n)
    Each call frame: O(1) space
    Stack space: O(n)
2.Current combination storage:
    currentCombination list: maximum size k
    Space: O(k)
3.Instance variables:
    comboLen, totalNumbers: O(1)
    Auxiliary Space: O(n + k) = O(n) since typically n ≥ k
    Total Space (including output):
4.Result storage:
    Number of combinations: C(n,k)
    Each combination size: k
    Total result space: O(C(n,k) × k)
    Total Space: O(C(n,k) × k + n)

*/
