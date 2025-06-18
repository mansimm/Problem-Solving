class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> set = new HashSet();
        for(int i:nums){
            set.add(i);
        }
        for(int x: set){//iteration over set avoid iteration over duplicate elements
            if(!set.contains(x-1)){
              // if set contains x-1 means x is not the starting point of seq, so we will not process it, we will only process element for which x-1 is not in set, means it is starting point of seq
                int cnt = 1;
                while(set.contains(x+cnt)){
                    cnt +=1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}

//Space c = O(n) and time c = O(n)
