/*
Steps:
1.	We will create a hashmap to store unique elements and its index 
2.	Iterate over array using i, for each element check if it is present in hashmap and if present check if i-map.get(nums[i]) is <=k, if yes return true
3.	Else add it in map with updated index
4.	In the end return false
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(seen.containsKey(nums[i]) && (i-seen.get(nums[i]))<=k){
                return true;
            }
            seen.put(nums[i],i);
        }
        return false;
    }
}
/*
The time complexity remains O(n), as we still iterate through the array once. The space complexity is O(min(n, k)), as the HashMap will contain at most min(n, k) elements at any time.
Space Complexity: O(min(n, k))
The space complexity is O(min(n, k)) where:
n = length of input array
k = maximum allowed distance between duplicate indices
Here's why:
1.HashMap storage: We store at most one entry per unique element in the array
2.Key insight: Due to the algorithm's logic, we never store more than necessary:
When we find a duplicate within distance k, we return immediately
When we find a duplicate beyond distance k, we update the stored index to the current position
3.Effective window: The algorithm maintains a "sliding window" effect where old indices get overwritten
4.Upper bounds:
O(n): In worst case, all elements are unique, so we store n entries
O(k): In practice, due to the distance constraint, we typically store fewer elements
  */
