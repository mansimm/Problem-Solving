class Solution {
    public String intToRoman(int num) {
     
        String roman="";
        
            while(num >= 1000)
            {
                roman+= "M";
                num = num-1000;
            }
            if(num>=900)
            {
                roman += "CM";
                num = num -900;
            }
            if(num>=500)
            {
                roman += "D";
                num = num-500;
            }
            if(num>=400)
            {
                roman += "CD";
                num = num - 400;
            }
            while(num>=100)
            {
                roman += "C";
                num = num - 100;
            }
            if(num>=90)
            {
                roman += "XC";
                num = num - 90;
            }
            if(num>=50)
            {
                roman += "L";
                num = num - 50;
            }
            if(num>=40)
            {
                roman += "XL";
                num = num - 40;
            }
            while(num>=10)
            {
                roman += "X";
                num = num - 10;
            }
            if(num==9)
            {
                roman += "IX";
                num = num - 9;
            }
             if(num>=5)
            {
                 roman += "V";
                 num = num - 5;
            }
            if(num==4)
            {
                roman += "IV";
                num = num - 4;
            }
            while(num!=0)
            {
                roman += "I";
                num -= 1;
            }
        
        return roman;
    }
}
