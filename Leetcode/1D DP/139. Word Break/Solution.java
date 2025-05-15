class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        //create hashset for O(1) lookup
        Set<String> set = new HashSet(wordDict);
        dp[0] = true;// empty string is also a valid string
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
/*
Time Complexity: O(n^2 * m)
1.The main loop runs from i = 1 to n, where n is the length of the string. This contributes O(n).
2.For each i, there's an inner loop that runs from j = 0 to i-1. In the worst case, this inner loop runs i times for each i. This nested structure contributes O(n^2).
3.Inside the inner loop, we perform two main operations: a. Checking if dp[j] is true - O(1) b. Checking if s.substring(j, i) is in the wordSet - O(m) in the worst case, where m is the average length of words in the dictionary. (Note: While HashSet lookup is generally O(1), creating the substring is O(m))
4.Combining these, we get O(n^2 * m).
In practice, the time complexity might be better than this worst-case scenario, especially if we can find valid segmentations early and break out of the inner loop.
Space Complexity: O(n + k)
1.dp array: We use a boolean array of size n+1, where n is the length of the string. This contributes O(n).
2.wordSet: We convert the wordDict list to a HashSet. If there are k unique words in the dictionary, this takes O(k) space.
3.Other variables use constant space.
4.Therefore, the total space complexity is O(n + k).
m' typically represents the length of the longest word in the dictionary (wordDict).
However, in my previous explanation, I incorrectly used 'm' to represent the average length of words in the dictionary. Let's correct this and provide a more precise analysis:
Corrected Time Complexity: O(n^3)
Here's why:
1.The outer loop runs n times (where n is the length of the input string s).
2.The inner loop also runs up to n times for each iteration of the outer loop.
3.Inside the inner loop, we perform the substring operation s.substring(j, i).
In Java, substring operation is generally considered O(1) in time complexity due to optimizations in modern Java implementations.
However, the length of this substring can be up to n characters in the worst case.
4.Checking if the substring is in the wordSet (HashSet) is O(1) in average case, but the time to generate and compare the substring can be up to O(n) in the worst case.
5.Therefore, the overall time complexity becomes O(n * n * n) = O(n^3).
Space Complexity: O(n + k) (This remains the same as in the previous explanation)
O(n) for the dp array
O(k) for the HashSet, where k is the number of words in wordDict
  */
