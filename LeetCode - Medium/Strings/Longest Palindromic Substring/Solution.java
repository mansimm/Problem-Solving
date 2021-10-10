class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        
        for(int i=0;i<s.length();i++)
        {
            String odd = expandPallindrome(s,i,i);
            String even = expandPallindrome(s,i,i+1);
            
            if(odd.length()>lps.length())
            {
                lps = odd;
            }
            if(even.length()>lps.length())
            {
                lps = even;
            }
        }
        return lps;
    }
    public String expandPallindrome(String s,int i,int j)
    {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        //System.out.println(s.substring(i+1,j));
        return s.substring(i+1,j);
    }
}
