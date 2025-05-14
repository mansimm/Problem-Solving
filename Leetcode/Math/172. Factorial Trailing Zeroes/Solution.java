class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while(n!=0){
            n = n/5;
            cnt+=n;
        }
        return cnt;
    }
}
/*
Time complexity: O(logn) since we are dividing n by 5 each time
Space complexity: O(1)
*/
