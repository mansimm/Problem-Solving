class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x>=0 && x<10){
            return true;
        }
        int reversed = 0;
        int n = x;
        while(n!=0){
            int digit = n%10;
            reversed = reversed*10 + digit;
            n = n/10;
        }
        return x==reversed;
    }
}
/*
the number of digits in x is ⌊log₁₀(x)⌋ + 1, where ⌊ ⌋ denotes the floor function.
In Big O notation, we typically drop constant factors and lower order terms. So, we simplify this to O(log x).
Space c = O(1)
*/
