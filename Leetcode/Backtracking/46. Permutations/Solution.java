class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList();

        dfs(nums, path, used, result);
        return result;
    }
    public void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result){
        if(path.size()==nums.length){
            result.add(new ArrayList(path));
            return;
        }   
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, path, used, result);

            path.remove(path.size() -1);
            used[i] = false;
        }
    }
}
/*
To analyze the time and space complexity of this code, let's break it down:
Time Complexity:
1.The algorithm generates all possible permutations of the input array.
2.For an array of length n, there are n! (n factorial) permutations.
3.Each permutation is of length n.
4.The DFS function is called n! times (once for each permutation).
5.Within each DFS call, we have a loop that runs n times.
Therefore, the time complexity is O(n * n!).
Space Complexity:
1.The result list stores all permutations. There are n! permutations, each of length n.
2.The used boolean array is of length n.
3.The path list can grow up to length n.
4.The recursion stack can go up to depth n.
The space complexity is dominated by the result list, which is O(n * n!).
In summary:
Time Complexity: O(n * n!)
Space Complexity: O(n * n!)
It's worth noting that this algorithm has factorial time and space complexity, which means it grows extremely quickly with the size of the input. It's practical only for small input sizes.
*/
