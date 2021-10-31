class Solution {
    public String addBinary(String a, String b) {
        
        int carry = 0;
        String ans = "";
        int i =0,j=0;
        for(i=a.length()-1,j=b.length()-1; i>=0 && j>=0; i--,j--)
        {
            if(a.charAt(i)=='1'&&b.charAt(j)=='1')
            {
                if(carry==0)
                    ans = "0"+ans;
                else
                    ans = "1"+ans;
                carry = 1;
            }
            else if((a.charAt(i)=='1'&&b.charAt(j)=='0') || (a.charAt(i)=='0'&&b.charAt(j)=='1'))
            {
                if(carry==0)
                    ans = "1"+ans;
                else
                {
                    ans = "0"+ans;
                    carry = 1;
                }
            }
            else// both 0
            {
                if(carry==0)
                    ans = "0"+ans;
                else
                    ans = "1"+ans;
                carry = 0;
            }
        }
        while(i>=0)
        {
            if(carry==0)
                ans = a.charAt(i)+ans;
            else if(a.charAt(i)=='1')
            {
                //carry =1 
                ans = "0"+ans;
                carry =1;
            }
            else
            {
                //carry=1
                ans = "1"+ans;
                carry = 0;
            }
                
            i--;
        }
        while(j>=0)
        {
           if(carry==0)
                ans = b.charAt(j)+ans;
            else if(b.charAt(j)=='1')
            {
                //carry =1 
                ans = "0"+ans;
                carry =1;
            }
            else
            {
                //carry=1
                ans = "1"+ans;
                carry = 0;
            }
            j--;
        }
        if(carry==1)
        {
            ans = "1"+ans;
        }
        return ans;
    }
}
