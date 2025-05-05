class Solution1 {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(i>=0 || j>=0 || carry>0){
            int sum = carry;
            if(i>=0){
                sum += a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum += b.charAt(j)-'0';
                j--;
            }
            result.insert(0, sum%2);
            carry = sum/2;
        }
        return result.toString();
    }
}
//Time c = O(n) where n is length of larger input string
//Space c = O(n)
