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
    for(int i=0;i<n;i++)
    {
        int area1, p1;
        p1=(tr[i].a+tr[i].b+tr[i].c)/2;
        area1=sqrt(p1*(p1-tr[i].a)*(p1-tr[i].b)*(p1-tr[i].c));
        for(int j=i+1;j<n;j++)
        {
            int area2, p2;
            p2=(tr[j].a+tr[j].b+tr[j].c)/2;
            area2=sqrt(p2*(p2-tr[j].a)*(p2-tr[j].b)*(p2-tr[j].c));

            if(area2<area1)
            {
                int temp;

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
