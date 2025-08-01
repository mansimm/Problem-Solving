class Solution {
    HashSet<Integer> done = new HashSet();
    HashMap<Integer,List<Integer>> dependency = new HashMap();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] arr: prerequisites){
            List<Integer> list = dependency.getOrDefault(arr[0], new LinkedList());
            list.add(arr[1]);
            dependency.put(arr[0], list);
        }
        int i = 0;
        while(i<numCourses){
            if(dfs(i, new HashSet())==false){
                return false;
            }
            i++;
        }
        return true;
    }
    private boolean dfs(int i, Set<Integer> visited){
        if(done.contains(i)){//already processed safely
            return true;
        }
        if(visited.contains(i)){//contains cycle, node under process in current DFS recursion cycle
            return false;
        }
        if(dependency.get(i)==null||dependency.get(i).size()==0){
            return true;
        }
        visited.add(i);
        for(int j: dependency.get(i)){
            if(dfs(j, visited) == false){
                return false;
            }
        }
        done.add(i);
        visited.remove(i);
        return true;
    }
}
//Time c = O(N+E) => O(n,p) n: numCourses p:no of prerequisites
//Space c = O(N+E) => O(n,p) n: numCourses p:no of prerequisites
