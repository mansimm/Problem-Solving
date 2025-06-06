/*
Steps:
Initial setup:
1.	If input arr has less than 3 elements return empty list
2.	Initialize list of list to store results
3.	Sort the array in ascending order
Main logic:
1.	Use 3 pointer I, j, k
2.	I starts from 0, j after I (i+1), and k from n-1
3.	I represent first number of triplets 
Find the triplets:
1.	For each value of I, move j and k towards each other and find  sum arr[i]+arr[j]+arr[k]==0
2.	If sum == 0 , we found triplets, add them to result list
3.	If sum<0 (negative) then j++(increasing the sum)
4.	If sum>0 (positive) then k—(decreasing the sum)
Avoiding duplicates
1.	Need to avoid duplicates for I so we are checking (i==0 || nums[i]!=nums[i-1])
2.	Also need to avoid duplicates for j and k so we are checking –
(j<k && nums[j]==nums[j+1]) j++
(j<k && nums[k]==nums[k-1]) k—
Optimization:
1.	The outer loop only needs to go up to n-2 (as we need at least 3 elements).
2.	Break the outer loop if nums[i] becomes positive (since the array is sorted, we can't find a sum of zero with remaining elements).
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums.length<3){
            return new ArrayList();
        }
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;
            if(i==0 || nums[i]!=nums[i-1]){//to avoid finding duplicate triplets
                while(j<k){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum==0){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j<k && nums[j]==nums[j+1]){
                            j++;
                        }
                        while(j<k && nums[k]==nums[k-1]){
                            k--;
                        }
                        j++;k--;// move to next or prev non duplicate j and k
                    }else if(sum>0){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
/*
Time Complexity: O(n²)
1.Sorting the array: O(n log n)
2.The outer loop runs n-2 times: O(n)
3.For each iteration of the outer loop, the two pointers j and k traverse the rest of the array in a single pass: O(n)
4.The nested loops (outer loop and while loop) result in O(n²)
Therefore, the overall time complexity is O(n log n + n²), which simplifies to O(n²) as n² dominates n log n for large n.
Space Complexity: O(1) to O(n)
1.The space used by the sorting algorithm: 
For many built-in sorting algorithms, this is O(log n) to O(n), depending on the implementation.
2.The output list res is not counted towards space complexity as per convention for output space.
3.Other than the output, we only use a constant amount of extra space for variables (i, j, k, sum, etc.).
Therefore, the space complexity is O(1) if we don't consider the space used by the sorting algorithm, or up to O(n) if we do include it.
Note: If we consider the space needed to store the output, in the worst case (where there are O(n²) triplets), the space complexity would be O(n²). However, it's common practice to not include the output space in the space complexity analysis.
This solution is quite efficient for the 3Sum problem, achieving quadratic time complexity, which is generally considered optimal for this problem (barring any specific constraints on the input data that could allow for more optimized solutions).
*/
