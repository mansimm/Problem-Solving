class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;// this will happen only for 9999 kind numsbrs which havall all 9 and need to add 1
        return newDigits;
    }
}
/*
Time complexity:
1.	In best case O(1), when right most element is less than 9
2.	In worst case O(n) when all elements of array are 9
Space complexity:
1.	In best case we are returning original array so O(1)
2.	In worst case creating new array so O(n+1) ie. Equal to O(n)

*/
