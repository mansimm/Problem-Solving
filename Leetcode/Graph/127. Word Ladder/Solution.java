class Pair{
    String word;
    int cnt;
    public Pair(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }
    public String getWord(){
        return word;
    }
    public int getCnt(){
        return cnt;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        return bfs(beginWord, endWord, set);
    }
    private int bfs(String beginWord, String endWord, Set<String> set){
        Queue<Pair> que = new ArrayDeque();
        que.offer(new Pair(beginWord, 1)); //begin counter with 1 as beginWOrd is considered as first word
        set.remove(beginWord);// Remove beginWord from set to avoid revisiting
        while(!que.isEmpty()){
            Pair pair = que.poll();
            String word = pair.getWord();
            int cnt = pair.getCnt();
            
            char[] arr = word.toCharArray();
            //StringBuilder sb = new StringBuilder(word);
            for(int i=0;i<arr.length;i++){
                char temp = arr[i];
                for(char c='a';c<='z';c++){
                    if(c!=temp){//avaid replace by same char
                        arr[i] = c;
                        String str = new String(arr);
                        if(set.contains(str)){
                            if(str.equals(endWord)){
                                return cnt+1;
                            }
                            set.remove(str);
                            que.offer(new Pair(str, cnt+1));
                        }
                    }
                }
                arr[i]=temp;
            }
        }
        return 0;
    }
}
/*
Time Complexity:
1. O(N), where N is the number of words in the wordList, for creating the HashSet from the wordList.
2. The BFS (Breadth-First Search) part:
   - In the worst case, we might need to examine all words in the wordList.
   - For each word, we try to change each character (let's say the word length is M) to all 26 letters of the alphabet.
   - This gives us O(N * M * 26) operations in the worst case.
3. Each operation inside the BFS loop (like creating a new string, checking set membership) takes O(1) time on average.
Therefore, the overall time complexity is O(N * M * 26), which can be simplified to O(N * M) since 26 is a constant.

Space Complexity:
1. O(N) for the HashSet that stores all words from the wordList.
2. O(N) for the queue used in BFS. In the worst case, we might need to store all words in the queue before finding the solution.
3. O(M) for the char array used to manipulate each word.
4. O(1) for other variables like temp, c, cnt, etc.
The overall space complexity is O(N + M), which can be simplified to O(N) since N (number of words) is typically much larger than M (length of each word).

Additional notes:
- The space complexity could potentially be reduced to O(min(N, 26^M)) because the number of possible words of length M using 26 letters is 26^M. However, in most practical cases, N will be smaller than 26^M.
- The time complexity, while theoretically O(N * M), is often much better in practice due to the early termination when the end word is found and the removal of words from the set as they are processed.
This solution provides a good balance between time and space efficiency for the Word Ladder problem.

*/
