/*
Steps:
1.	First we will create an arrayList of int[] to store result
2.	We will sort array by first element (ie. x) of array element
3.	We will iterate over sorted array
4.	For each element we will check if ans.isEmpty or y of last element of ans is less than x of current pair, if yes we will insert it in array
5.	If not, for last element of ans list we will set its y  = Math.max(currents y, ans last elements y)
6.	In the end we will convert list of arrays to 2D array
  */
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList();
        Arrays.sort(intervals, Comparator.comparingInt(x ->x[0]));
        for(int[] interval:intervals){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1]<interval[0]){
                ans.add(interval);
            }else{
                ans.get(ans.size()-1)[1] = Math.max(interval[1], ans.get(ans.size()-1)[1]);
            }
        }  
        return ans.toArray(int[][]::new);
    }
}
//Time c = O(nlogn) , space c = O(n) 
