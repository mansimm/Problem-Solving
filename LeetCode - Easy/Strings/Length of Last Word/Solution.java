class Solution {
    public int lengthOfLastWord(String s) {
        
        int word = 0, len=0;
        for(int i=s.length()-1;i>=0;i--)
        {
           if(s.charAt(i)==' '&& word==0)
           {
               continue;
           }
           else if(s.charAt(i)==' '&& word==1)
           {
               return len;
           }
            else
            {
                word=1;
                len++;
            }
        }
        return len;
    }
}
