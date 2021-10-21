class Solution {
    public String convert(String s, int numRows) {
        
        String ans = "";
        if(numRows==1)
        {
            return s;
        }
        if(s==null||s.length()==1||s.length()<numRows)
        {
            return s;
        }
        
        for(int i=0;i<numRows;i++)
        {
            int j=i;
            ans += s.charAt(j);
            while(j<s.length() && (j+(numRows-1)*2-(2*i)) < s.length())
            {   
                if(i>0 && i<numRows-1)
                 {
                     ans += s.charAt(j+(numRows-1)*2-(2*i));
                 }
               
                if(j+(numRows-1)*2<s.length())
                {
                    ans += s.charAt(j+(numRows-1)*2);
                }
                 j += (numRows-1)*2; 
                
            }
            //System.out.println(i+" th row = "+ans);
        }
        return ans;
    }
}
