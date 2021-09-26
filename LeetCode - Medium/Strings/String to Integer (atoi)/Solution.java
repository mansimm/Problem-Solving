class Solution {
    public int myAtoi(String s) {
        
        boolean neg = false;
        long num = 0 ;
        int sign = 0 ;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ' && sign == 0)
            {
                continue;
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                num = num*10 +(s.charAt(i) - '0');
                sign = 1;
                
                if(num> Integer.MAX_VALUE)
                {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                
            }
            else if(s.charAt(i)=='-' && sign == 0)
            {
                neg = true;
                sign = 1;
            }
            else if(s.charAt(i)=='+' && sign == 0)
            {
                neg = false;
                sign = 1;
            }
            else
            {
                break;
            }
        }
        
        return neg ? (-1*(int)num) : (int)num;
    }
}
