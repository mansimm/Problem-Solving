/*
Steps:
1.	Create 2 arrays to store roman chars and respective values, in descending order by value
2.	Iterate over each element of array
3.	For each element, subtract it from num till num is less than element, during this loop keep on appending respective char to ans var
4.	Here we need to modify string so we are using mutable StringBuilder
  */
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV", "I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                num = num - values[i];
                roman.append(symbol[i]);
            }
        }
        return roman.toString();
    }
}
//Note: The time complexity of this algorithm is O(1) because it always performs a fixed number of operations regardless of the input size. The space complexity is also O(1) as it uses a fixed amount of additional space.
