/*
Steps:
1.	Start from i=0, increment i till charAt i is non space
2.	Then assign j=i+1, increment j till charAt j is space
3.	Prepend result by substring(i,j)
4.	Assign i=j
5.	Repeat from point 1 to 4 till i<str.length
*/
class Solution2 {
    public String reverseWords(String s) {
        String res = "";
        int i=0;
        int n = s.length();
        while(i<n){
            while(i<n&& s.charAt(i)==' '){
                 i++;
            }
            if(i>=n){
                break;
            }
            int j = i+1;
            while(j<n && s.charAt(j)!=' '){
                j++;
            }
            if(res==""){
                res = s.substring(i,j);
            }
            else{
                res = s.substring(i,j) + " "+ res;
            }
            i=j;
        }
        return res;
    }
}
//Time complexity: O(n)
//Space complexity: O(n), bcoz result string can go as long as input string of length n
