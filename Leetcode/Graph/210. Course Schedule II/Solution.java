class Solution {
    HashSet<Integer> done = new HashSet();
    HashMap<Integer, List<Integer>> prereq = new HashMap();
    int ans[];
    int cnt=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.ans = new int[numCourses];
        for(int[] arr: prerequisites){
            List<Integer> list = prereq.getOrDefault(arr[0], new ArrayList());
            list.add(arr[1]);
            prereq.put(arr[0], list);
        }
        int i=0;
        while(i<numCourses){
            if(dfs(i, new HashSet())==false){
                return new int[0];
            }
            i++;
        }
        return ans;
    }
    private boolean dfs(int i, HashSet<Integer> visited){
        if(visited.contains(i)){
            return false;
        }
        if(done.contains(i)){
            return true;
        }
        if(prereq.get(i)==null || prereq.get(i).size()==0){
            ans[cnt++] = i;
            done.add(i);
            return true;
        }
        visited.add(i);
        for(int j : prereq.get(i)){
            if(dfs(j, visited)==false){
                return false;
            }
        }
        done.add(i);
        ans[cnt++]=i;
        visited.remove(i);
        return true;
    }
}
/*
Time Complexity:
1. Building the prerequisite graph:
   - Iterating through prerequisites: O(E), where E is the number of prerequisites
   - Adding to HashMap and ArrayList: O(1) amortized
   Total: O(E)
2. DFS traversal:
   - In the worst case, we might need to visit each course and each prerequisite edge once
   - We call dfs() for each course: O(N), where N is the number of courses
   - Within each dfs() call, we might visit all prerequisites: O(E)
   Total: O(N + E)
Overall Time Complexity: O(N + E)
Space Complexity:
1. HashMap (prereq): O(N + E)
   - In the worst case, each course might have prerequisites, so we store all courses and edges
2. HashSet (done): O(N)
   - Stores all courses in the worst case
3. Result array (ans): O(N)
   - Stores all courses
4. Recursion stack and visited set in dfs(): O(N)
   - In the worst case (a linear chain of courses), the recursion depth could be N
Overall Space Complexity: O(N + E)
Additional notes:
- N is the number of courses (numCourses)
- E is the number of prerequisites (prerequisites.length)
- In the worst case, E could be O(N^2) if every course is a prerequisite for every other course. However, in practice, E is often much smaller than N^2.
This solution has optimal time complexity for the problem, as we need to process each course and each prerequisite relationship at least once to determine the correct order. The space complexity is also reasonable, as we need to store the graph structure and keep track of visited nodes.

*/
