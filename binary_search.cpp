/*    Binary Search  

	Input - numbers in ascending or descending order(integers here and in ascending order) and key to find
	
	Output - Find if key is present in list of numbers or not, if present then print position whre it is present else print key not
		 found

	Time Complexity - O(logn)
*/

#include<iostream>
using namespace std;

int main()
{
	int numbers[100];
	int n;
	int key;
	int i,mid,low,high,flag=0;

	cout<<"\n Enter total number of numbers : ";
	cin>>n;
	low=0;
	high=n-1;
	cout<<"\n Enter Numbers in ascending order: ";
	for(int i=0;i<n;i++)
	{
		cin>>numbers[i];
	}
	cout<<"\n Your Numbers : ";
	for(i=0;i<n;i++)
	{
		cout<<" "<<numbers[i]<<" ";
	}
	cout<<"\n Enter Key to find : ";
	cin>>key;

	while(low<high)
	{	
		mid=(low+high)/2;  

		if(numbers[i]==key)
		{
			cout<<"\n Key is found at position "<<(i+1)<<"\n";
			flag=1;
			break;
		}
		else if(numbers[i]>key)
		{
			high=i-1;
		}
		else
		{
			low=i+1;
		}
	
	}

	if(flag==0)
	{
		cout<<"\n Key not found in list !";
	}
	return 0;
}

/*		OUTPUT

(base) mansi@mansi-Vostro-15-3568:~$ g++ linear_search.cpp
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 Enter total number of numbers : 5

 Enter Numbers : 1
2
3
4
5

 Your Numbers :  1  2  3  4  5 
 Enter Key to find : 5

 Key is found at position 5
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 Enter total number of numbers : 7

 Enter Numbers : 1
2
3
4
5
6
8

 Your Numbers :  1  2  3  4  5  6  8 
 Enter Key to find : 3

 Key is found at position 3
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 Enter total number of numbers : 9

 Enter Numbers : 1
2
3
4
5
6
7
8
9

 Your Numbers :  1  2  3  4  5  6  7  8  9 
 Enter Key to find : 5

 Key is found at position 5
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 Enter total number of numbers : 5

 Enter Numbers : 1
2
3
4
5

 Your Numbers :  1  2  3  4  5 
 Enter Key to find : 6

 Key is not found ! 
(base) mansi@mansi-Vostro-15-3568:~$ 


*/
