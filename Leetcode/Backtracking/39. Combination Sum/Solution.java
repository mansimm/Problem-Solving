class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, new ArrayList());
        return ans;
    }
    public void dfs(int[] candidates, int target, int idx, List<Integer> path){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList(path));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}
/*
Let's analyze the time and space complexity of this code:

Time Complexity:

1. The algorithm explores all possible combinations that sum up to the target.
2. In the worst case, each recursive call branches into n (where n is the length of candidates) more recursive calls.
3. The maximum depth of the recursion tree is target/min(candidates), where min(candidates) is the smallest number in the candidates array.

Therefore, the time complexity is O(n^(target/min(candidates))), where n is the length of the candidates array.

Space Complexity:

1. The `ans` list stores all valid combinations. The number of combinations depends on the input, but in the worst case, it could be exponential.
2. The `path` list in each recursive call can grow up to a maximum length of target/min(candidates).
3. The recursion stack can go up to a depth of target/min(candidates).

The space complexity is O(target/min(candidates)) for the recursion stack and path, plus the space needed for storing all valid combinations in `ans`.

In summary:
- Time Complexity: O(n^(target/min(candidates)))
- Space Complexity: O(target/min(candidates)) + space for storing all valid combinations

It's important to note that this is a worst-case analysis. The actual time and space used can vary significantly depending on the specific input values. For example:

1. If the candidates array contains only large numbers, the recursion depth will be shallower.
2. If there are many ways to sum up to the target, the `ans` list will be larger.
3. If there are few or no ways to sum up to the target, the algorithm might terminate much faster.

This algorithm can be quite efficient for small to medium-sized inputs, but it can become very slow for large inputs or when there are many possible combinations.
*/
