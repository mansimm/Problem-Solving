class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
       int load = 0;
       int road[]=new int[1001];
        for(int[] trip: trips)
        {
            road[trip[1]] += trip[0];
            road[trip[2]] -= trip[0];
        }
        for(int i=0;i<1001 && load<=capacity;i++)
        {
            load += road[i];
            if(load>capacity)
            {
                return false;
            }
        }
        return true;
        
     
    }
}
