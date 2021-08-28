/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

 
*/


class Solution {
    public int romanToInt(String s) {
        
        int num = 0;
        for(int i=0;i<s.length();i++)
        {
            char x = s.charAt(i);
            if(x=='I')
            {
                num +=1;
            }
            else if(x=='V'&& i>=1 && s.charAt(i-1)=='I')
            {
                num +=3;
            }      
            else if( x=='V')
            {
                num += 5;
            }
            else if(x=='X'&& i>=1 && s.charAt(i-1)=='I')
            {
                num += 8;
            }
            else if(x=='X')
            {
                num += 10;
            }
            else if(x=='L' && i>=1 && s.charAt(i-1)=='X')
            {
                num += 30;
            }
            else if(x == 'L')
            {
                num += 50;
            }
            else if(x=='C' && i>=1 && s.charAt(i-1)=='X')
            {
                num += 80;
            }
            else if(x == 'C')
            {
                num += 100;
            }
            else if(x=='D' && i>=1 && s.charAt(i-1)=='C')
            {
                num += 300;
            }
            else if(x == 'D')
            {
                num += 500;
            }
            else if(x=='M' && i>=1 && s.charAt(i-1)=='C')
            {
                num += 800;
            }
            else if(x == 'M')
            {
                num += 1000;
            }
                
            
        }
        return num;
    }
}
