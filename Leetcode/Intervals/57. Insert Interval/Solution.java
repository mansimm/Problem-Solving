class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList();
        if(intervals.length == 0){
            ans.add(newInterval);
        }
        boolean isInserted = false;
        for(int i=0;i<intervals.length;i++){
            if(isInserted){
                insert(ans, intervals[i]);
            }else if(intervals[i][0]<newInterval[0]){
                insert(ans, intervals[i]);
            }else{
                insert(ans, newInterval);
                isInserted = true;
                insert(ans, intervals[i]);
            }        
        }
        if(!isInserted){
            insert(ans, newInterval);
        }
        return ans.toArray(int[][]::new);
    }

    public void insert(List<int[]> ans, int interval[]){
        if(ans.isEmpty() || ans.getLast()[1] < interval[0]){
            ans.add(interval);
        }else{
            ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
        }
    }
}
/*
Time c = O(n), space c= O(n)
Auxiliary space for ans list:
At most, you store all n+1 intervals if no merges occur → O(n)
No recursion or extra data structures (besides ans).
*/
