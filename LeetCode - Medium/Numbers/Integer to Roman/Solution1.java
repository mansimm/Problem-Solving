class Solution {
    public String intToRoman(int num) {
     
        StringBuilder roman = new StringBuilder();
        
            while(num >= 1000)
            {
                roman.append("M");
                num = num-1000;
            }
            if(num>=900)
            {
                roman.append("CM");
                num = num -900;
            }
            if(num>=500)
            {
                roman.append("D");
                num = num-500;
            }
            if(num>=400)
            {
                roman.append("CD");
                num = num - 400;
            }
            while(num>=100)
            {
                roman.append("C");
                num = num - 100;
            }
            if(num>=90)
            {
                roman.append("XC");
                num = num - 90;
            }
            if(num>=50)
            {
                roman.append("L");
                num = num - 50;
            }
            if(num>=40)
            {
                roman.append("XL");
                num = num - 40;
            }
            while(num>=10)
            {
                roman.append("X");
                num = num - 10;
            }
            if(num==9)
            {
                roman.append("IX");
                num = num - 9;
            }
             if(num>=5)
            {
                 roman.append("V");
                 num = num - 5;
            }
            if(num==4)
            {
                roman.append("IV");
                num = num - 4;
            }
            while(num!=0)
            {
                roman.append("I");
                num -= 1;
            }
        
        return roman.toString();
    }
}
