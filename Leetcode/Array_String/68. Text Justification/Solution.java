// Steps:
// 1.	Start with i=0 and iterate till n, end of array(Outer loop)
// 2.	Assign j=i+1, len = arr[i].len, start inner loop and check if j<n and len+arr[j].lenght()+(j-i-1) is less than maxWidth(check comment in code for more info)
// 3.	If it is then add arr[j].len to len, j++
// 4.	After inner loop completes calculate noOfWord=(j-i) and  total no of spaces needed diff=maxWidth-len
// 5.	If maxwidth==1 or  j>=n means we are on last line so leftAdust it
// 6.	Else rightAdjust

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> ans = new ArrayList();
        int i = 0;
        int j = 0;
        int len = 0;
        int n = words.length;

        while(i<n){
            j=i+1;
            len = words[i].length();
            //(j-i-1) = number of places where spaces needs to be added
            while(j<n && len+words[j].length()+(j-i-1) < maxWidth){
                //if u think (j-i+1) gives (no of spaces between word -1) bcoz in this prev loop we already incremented j, which is now pointing to next word which will break above condition and will not be part of current line
                //eg. For 4rth(i=3) word len became more than maxWidth  so , noOfWords=j-i=3-0=3
                //spaces (j-i-1)=3-0-1=2. 2 spaces between 3 words
                len += words[j].length();
                j++;
            }
            int noOfWords = j - i;
            int diff = maxWidth - len;

            //j>=n meaning last line of result
            if(noOfWords==1 || j>=n){
                ans.add(leftJustify(words, i, j, diff));
            }else{
                ans.add(middleJustify(words, i, j, diff));
            }
            i=j;
        }
        return ans;
    }

    public String leftJustify(String[] words, int i, int j, int diff){
        int spacesOnRight = diff - (j-i-1);
        StringBuilder line = new StringBuilder(words[i]);
        for(int k=i+1;k<j;k++){//not including j as it breaks condition of maxwidth
            line.append(" "+words[k]);
        }
        line.append(" ".repeat(spacesOnRight));
        return line.toString();
    }
    public String middleJustify(String[] words, int i, int j, int diff){
        int spaceNeeded = (j-i-1);
        int space = diff/spaceNeeded;//even spaces needs to add
        int extra = diff%spaceNeeded;// extra spaces after even dividing spaces
        StringBuilder line = new StringBuilder(words[i]);
        for(int k=i+1;k<j;k++){
            int spacesToApply = space + (extra-- >0 ? 1 : 0);
            line.append(" ".repeat(spacesToApply)+words[k]);
        }
        return line.toString();
    }
}
/*
https://youtu.be/GqXlEbFVTXY
Time complexity: O(lines*maxWidth)
Space Complexity: O(lines*maxWidth)
Where lines is no. of lines in result.
“ “.repeat() has complexity of o(n) internally
*/

