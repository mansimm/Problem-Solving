class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums){
            result = result ^ n;//XOR
        }
        return result;
    }
}
// The key to this solution is understanding the properties of XOR:
// XOR of a number with itself is 0: a ^ a = 0
// XOR of a number with 0 is the number itself: a ^ 0 = a
// XOR is commutative and associative: a ^ b ^ c = c ^ b ^ a = (a ^ b) ^ c = a ^ (b ^ c)
// Time c = O(n) ans space O(1)
