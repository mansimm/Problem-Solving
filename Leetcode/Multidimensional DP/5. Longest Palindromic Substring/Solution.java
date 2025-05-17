class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==1 || n==0){
            return s;
        }
        String lps = "";
        for(int i=1;i<n;i++){
            //check odd length pallindrom
            int low = i;
            int high = i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==n){
                    break;
                }
            }
            String substr = s.substring(low+1, high);
            if(substr.length()>lps.length()){
                lps = substr;
            }
            //check even length pallindrom
            low = i-1;
            high = i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==n){
                    break;
                }
            }
            substr = s.substring(low+1,high);
            if(substr.length()>lps.length()){
                lps = substr;
            }
        }
        return lps;
    }
}
//Time c : O(n*n),space c :O(n)
