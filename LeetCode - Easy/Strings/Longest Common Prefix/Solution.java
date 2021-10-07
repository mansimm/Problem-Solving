class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prefix = strs[0];
        
        for(int i=1;i<strs.length;i++)
        {
            String x = "";
            int j=0;
            while(j<prefix.length() && j<strs[i].length() && prefix.charAt(j)==strs[i].charAt(j) )
            {
                x+=prefix.charAt(j);
                j++;
            }
            if(x.length() < prefix.length())
            {
                prefix = x;
            }
        }
        return prefix;
    }
}
