class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n==1;
    }

    public int getNext(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            n = n/10;
            sum = sum + digit*digit;
        }
        return sum;
    }
}
//This solution efficiently solves the Happy Number problem with a time complexity of O(log n) and a space complexity of O(log n), where the log n factor comes from the number of digits in n and the potential length of the cycle.
