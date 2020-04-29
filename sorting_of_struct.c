/*
  Hackerrank Problem
  
  You are given n triangles, specifically, their sides a, b and c. Print them in the same style but sorted by their areas
  from the smallest one to the largest one. It is guaranteed that all the areas are different.

The best way to calculate a volume of the triangle with sides a,b and c is Heron's formula:

area=sqrt(p*(p-a)*(p-b)*(p-c))
where
p=(a+b+c)/2

Input Format

First line of each test file contains a single integer n. lines follow with a ,b and c on each separated by single spaces.

Output Format

Print exactly n lines. On each line print integers separated by single spaces, which are a,b and c of the corresponding 
triangle.

Sample Input 0

3
7 24 25
5 12 13
3 4 5

Sample Output 0

3 4 5
5 12 13
7 24 25

*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct triangle
{
	int a;
	int b;
	int c;
};

typedef struct triangle triangle;
void sort_by_area(triangle* tr, int n) {
	/**
	* Sort an array a of the length n
	*/
    int area[n];
    float p;
    for(int i=0;i<n;i++)
    {
        p=(tr[i].a+tr[i].b+tr[i].c)/2.0;
        //use 2.0 compulsary int/int gives int, int/float gives float
        area[i]=(p*(p-tr[i].a)*(p-tr[i].b)*(p-tr[i].c));
        //formula without sqrt as areas are different guarenteed 
        //because sqrt dosent work well with float values
    }

    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(area[j]<area[i])
            {
                int temp;

                temp=area[i];
                area[i]=area[j];
                area[j]=temp;

                temp=tr[i].a;
                tr[i].a=tr[j].a;
                tr[j].a=temp;

                temp=tr[i].b;
                tr[i].b=tr[j].b;
                tr[j].b=temp;

                temp=tr[i].c;
                tr[i].c=tr[j].c;
                tr[j].c=temp;

            }
        }
    }
}

int main()
{
	int n;
	scanf("%d", &n);
	triangle *tr = malloc(n * sizeof(triangle));
	for (int i = 0; i < n; i++) {
		scanf("%d%d%d", &tr[i].a, &tr[i].b, &tr[i].c);
	}
	sort_by_area(tr, n);
	for (int i = 0; i < n; i++) {
		printf("%d %d %d\n", tr[i].a, tr[i].b, tr[i].c);
	}
	return 0;
}
/*  
  OUTPUT
  
  Input (stdin)
Download

    3

    7 24 25

    5 12 13

    3 4 5

Your Output (stdout)

    3 4 5

    5 12 13

    7 24 25

Expected Output
Download

    3 4 5

    5 12 13

    7 24 25



*/
