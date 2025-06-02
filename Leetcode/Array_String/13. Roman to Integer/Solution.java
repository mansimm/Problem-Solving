/*
Steps:
1.	Create a hashmap for values of roman characters
2.	Iterate over given string from end to start
3.	For each letter fetch its value from hashmap
4.	Maintain previous char value in prev variable
5.	If this value is less than prev value then subtract it from total eg. For IV => I le less than V so subtract I value from V value
6.	Else add current char value to total
  */
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int n = s.length();
        int prevValue = 0;
        Map<Character, Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        for(int i=n-1;i>=0;i--){
            int val = map.get(s.charAt(i));
            if(val<prevValue){
                total-= val;
            }else{
                total+= val;
            }  
            prevValue = val;
        }
        return total;
    }
}
//Time c O(n) and space O(n)
