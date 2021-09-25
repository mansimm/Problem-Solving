class Solution {
    public boolean isValid(String s) {
        
        String temp="";
        String pop="";
        for(int i=0;i<s.length();i++)
        {
            String in = s.charAt(i)+"";
            String expected = "";
            
            
            if(in.equals("}")||in.equals("]")||in.equals(")"))
            {
                if(in.equals("}"))
                {
                    expected = "{";
                }
                else if(in.equals(")"))
                {
                     expected = "(";
                }
                else if(in.equals("]"))
                {
                    expected = "[";
                }
                if(temp==null||temp.length()==0)
                {
                    return false;
                }
                pop = temp.charAt(temp.length()-1)+"";
                if(!pop.equals(expected))
                {
                    return false;
                }
                else
                {
                    temp = temp.substring(0,temp.length()-1);
                }
            }
            else
            {
                temp += in;
            }
           
        }
        if(temp==null||temp.length()==0)
        {
            return true;
        }
        return false;
        
    }
}
