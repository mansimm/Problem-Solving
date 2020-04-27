/*
# HAckerranck

You are given an array of integers,marks, denoting the marks scored by students in a class.

    The alternating elements marks0,marks2,marks4 and so on denote the marks of boys.
Similarly,
    marks1,marks3 and so on denote the marks of girls.

The array name,marks, works as a pointer which stores the base address of that array. In other words, marks contains the address where
marks0 is stored in the memory.

Complete the function, marks_summation(int* marks, char gender, int number_of_students) which returns the total sum of:

1.marks of boys if gender= b

2.marks of girls if gender=g

The locked code stub reads the elements of along with .
Then, it calls the function marks_summation(marks, gender, number_of_students) to get the sum of alternate elements as explained above 
and then prints the sum.

# Input Format

   1. The first line contains number_of_students, denoting the number of students in the class, hence the number of elements 
      in marks.
   2. Each of the  number_of_students subsequent lines contains markssi.
   
   3. The next line contains gender
   
# Output Format

The output should contain the sum of all the aternate elements in marks as explained above.
. 
*/

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

//Complete the following function.

int marks_summation(int* marks, int number_of_students, char gender) {
  //Write your code here.
  int sum=0;
  if(gender=='g')
  {
      for(int i=1;i<number_of_students;i=i+2)
      {
          sum=sum+*(marks+i);
      }
  }
  else if(gender=='b')
  {
      for(int i=0;i<number_of_students;i=i+2)
      {
          sum=sum+*(marks+i);
      }
  }
  return sum;
}

int main() {
    int number_of_students;
    char gender;
    int sum;
  
    scanf("%d", &number_of_students);
    int *marks = (int *) malloc(number_of_students * sizeof (int));
 
    for (int student = 0; student < number_of_students; student++) {
        scanf("%d", (marks + student));
    }
    
    scanf(" %c", &gender);
    sum = marks_summation(marks, number_of_students, gender);
    printf("%d", sum);
    free(marks);
 
    return 0;
}

/*
Input (stdin)
Download

    3

    3

    2

    5

    b

Your Output (stdout)

    8

Expected Output
Download

    8

*/
