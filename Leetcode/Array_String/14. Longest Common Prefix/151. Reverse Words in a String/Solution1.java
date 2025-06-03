/*
Steps:
1.	Trim starting and ending space using trim()
2.	Then convert string to array of string by splitting using spaces
3.	Then revers array elements by two pointer method
4.	Then join all array elements and return result
  */
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        //System.out.println(Arrays.toString(arr)); // print the array before reversing
        //System.out.println(arr.length);
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            System.out.println(arr[i] + " " + arr[j]  );
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return String.join(" ",arr);
    }
}
//Note: Both time and space complexities of above solution is O(n).
