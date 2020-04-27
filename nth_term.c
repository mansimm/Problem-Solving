/*
#Hackerranck

Task

There is a series,S, where the next term is the sum of pervious three terms. Given the first three terms of the series, a, b, and

c respectively, you have to output the nth term of the series using recursion.

Recursive method for calculating nth term is given below.

s(n)=a   ........if n=1,
    =b   ........if n=2,
    =c   ........if n=3
    =s(n-1)+s(n-2)+s(n-3)  ..........otherwise
    
Input Format

    The first line contains a single integer,n.
    
The next line contains 3 space-separated integers,
a,b , and c

Output Format

Print the nth term of the series s(n),
.
*/

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
//Complete the following function.

int find_nth_term(int n, int a, int b, int c) {
  //Write your code here.
  if(n==1)
  {
      return a;
  }
  else if(n==2)
  {
      return b;
  }
  else if(n==3)
  {
      return c;
  }
  else
  {
      return find_nth_term(n-1,a,b,c)+find_nth_term(n-2,a,b,c)+find_nth_term(n-3,a,b,c);
  }
}

int main() {
    int n, a, b, c;
  
    scanf("%d %d %d %d", &n, &a, &b, &c);
    int ans = find_nth_term(n, a, b, c);
 
    printf("%d", ans); 
    return 0;
}


/*


OUTPUT
nput (stdin)
    5

    1 2 3

Your Output (stdout)

    11

Expected Output

    11

*/
