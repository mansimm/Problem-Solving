/*
Steps:
1.	create list of integers to return ans
2.	if input str s.length is 0 or 1 return it as is.
3.	Initialize vars wordCount=word.length, wordSize=word[0].length, N=s.length
4.	Create hashMap originalCount and store all words and their counts on it
5.	Then start iteration on offset goes from 0 to wordSize (we will check all combinations starting from 0,1,2,…wordSize-1)
6.	Inside it initialize currentCount to store current loop count for current offset
7.	Assign start=offset, end = offset, count=0
8.	Iterate on end to end+wordSize<N and increment end+=wordSize
9.	Fetch the word currentWord=s.substring(end, end+wordSize) and if it is present in originalCount, map add it to currentMap, count++
10.	In inner while loop check if count of currentWord in currentCount Map is greater than count in originalCount Map,
11.	If yes then fetch starting word, startword = s.substring(start, start+wordSize), decrements startWords count in currentCount and count--.
12.	After while loop check if count==wordcount if yes add start to ans list
13.	If currentWord not in originalCount(step 9) set count=0, start=end+wordSize,currentCount.cleare()
*/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        int wordSize = words[0].length();
        int wordCount = words.length;
        int N = s.length();

        HashMap<String,Integer> originalCount = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            originalCount.put(words[i], originalCount.getOrDefault(words[i],0)+1);
        }

        for(int offset = 0; offset<wordSize; offset++){//to cover all possible starting of substrings
            HashMap<String,Integer> currentCount = new HashMap<>();
            int start = offset;
            int count = 0;
            for(int end = offset; end + wordSize <= N; end += wordSize){
                String currWord = s.substring(end, end + wordSize);
                if(originalCount.containsKey(currWord)){
                    currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
                    count++;

                    while(currentCount.get(currWord)>originalCount.get(currWord)){//handle duplicates
                        String startWord = s.substring(start,start+wordSize);
                        currentCount.put(startWord, currentCount.get(startWord)-1);
                        start+=wordSize;
                        count--;                        
                    }

                    if(count == wordCount){
                        ans.add(start);
                    }
                }
                else{
                    count = 0;
                    start = end + wordSize;
                    currentCount.clear();
                }
            }
        }
        return ans;
    }
}
/*
Let's analyze the time and space complexity of this solution.
Time Complexity:
1. The outer loop runs `wordSize` times (0 to wordSize-1).
2. For each iteration of the outer loop, the inner loop potentially traverses the entire string `s`, moving `wordSize` characters at a time. This means it makes approximately N/wordSize iterations, where N is the length of string `s`.
3. Inside the inner loop, we perform constant time operations (HashMap lookups, updates, and comparisons) for each word.
4. The while loop inside the inner loop can potentially remove all words added so far, but over the entire execution of the algorithm, it can't remove more words than it adds. So its amortized cost doesn't add to the overall complexity.
Therefore, the total time complexity is O(N * wordSize).
Space Complexity:
1. We use two HashMaps: `originalCount` and `currentCount`. In the worst case, these could contain all unique words from the `words` array. If there are k unique words, this would take O(k) space.
2. The `ans` list could potentially contain all valid starting indices. In the worst case, this could be O(N) if every position is a valid starting index.
3. We use a few integer variables which take constant space.
4. The input `s` and `words` are not counted in the space complexity as they are part of the input.
Therefore, the total space complexity is O(k + N), where k is the number of unique words in the `words` array and N is the length of string `s`.

In the worst case where all words are unique, k could be equal to the total number of words, let's call it m. So we could also express the space complexity as O(m + N).
It's worth noting that this solution is quite efficient in terms of both time and space complexity for this problem, which is known to be challenging.
*/
