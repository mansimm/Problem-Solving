class Solution {
    HashMap<String, List<Pair>> adj = new HashMap();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //create adjasancy list
        for(int i=0;i<equations.size();i++){
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double value = values[i];
            adj.computeIfAbsent(a, k-> new ArrayList()).add(new Pair(b, value));
            adj.computeIfAbsent(b, k-> new ArrayList()).add(new Pair(a, 1/value));
        }
        double[] ans = new double[queries.size()];
        for(int j=0;j<queries.size();j++){
            List<String> query = queries.get(j);
            ans[j] = bfs(query.get(0), query.get(1));
        }
        return ans;
    }
    private double bfs(String src, String des){
        if(!adj.containsKey(src) || !adj.containsKey(des)){
            return -1.0;
        }
        HashSet<String> visited = new HashSet();
        Queue<Pair> que = new LinkedList();
        que.offer(new Pair(src, 1.0));
        while(!que.isEmpty()){
            Pair pair = que.poll();
            String node = pair.getKey();
            Double weight = pair.getValue();
            if(node.equals(des)){
                return weight;
            }

            List<Pair> neighbors = adj.get(node);
            if(neighbors!=null){
                for(Pair neighbor: neighbors){
                    String nei = neighbor.getKey();
                    Double neiWeight = neighbor.getValue();
                    if(!visited.contains(nei)){
                        que.offer(new Pair(nei, neiWeight*weight));
                        visited.add(nei);
                    }
                }
            }
        }
        return -1.0;
    }
}

class Pair{
    String key;
    Double value;
    Pair(String key, Double value){
        this.key=key;
        this.value=value;
    }

    public String getKey(){
        return key;
    }
    public Double getValue(){
        return value;
    }
}

/*
Time Complexity:
1.Building the adjacency list (in calcEquation method):
Iterates through all equations: O(E), where E is the number of equations
Each insertion is O(1) amortized for HashMap operations Total: O(E)
2.BFS (for each query):
In the worst case, BFS might visit all nodes and edges in the graph
Each node is visited at most once: O(V), where V is the number of unique variables
Each edge is considered at most once: O(E) Total for one BFS: O(V + E)
3.Processing all queries:
BFS is performed for each query: O(Q * (V + E)), where Q is the number of queries
Overall Time Complexity: O(E + Q * (V + E))
Space Complexity:
1.Adjacency List (adj HashMap):
Stores all nodes and edges: O(V + E)
2.BFS:
Queue: In the worst case, might contain all nodes: O(V)
Visited Set: Might contain all nodes: O(V)
3.Result array:
Stores result for each query: O(Q)
Overall Space Complexity: O(V + E + Q)
Additional notes:
V is the number of unique variables (nodes in the graph)
E is the number of equations (edges in the graph)
Q is the number of queries

*/
