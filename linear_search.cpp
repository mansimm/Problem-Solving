/*    Linear Search  

	Input - numbers in random order(integers here) and key to find

	Output - Find if key is present in list of numbers or not, if present then print position whre it is present else print key not
		 found

	Time Complexity - O(n)
*/

#include<iostream>
using namespace std;

int main()
{
	int numbers[100];
	int n;
	int key;
	int i;

	cout<<"\n Enter total number of numbers : ";
	cin>>n;
	cout<<"\n Enter Numbers : ";
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

	for(i=0;i<n;i++)
	{
		if(numbers[i]==key)
		{
			cout<<"\n Key is found at position "<<(i+1)<<"\n";
			break;
		}
		if(i==(n-1))
		{
			cout<<"\n Key is not found ! \n";
			break;
		}
	}
	
	return 0;
}

/*		OUTPUT

(base) mansi@mansi-Vostro-15-3568:~$ g++ linear_search.cpp
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 Enter total number of numbers : 5

 Enter Numbers : 5
1
2
3
7

 Your Numbers :  5  1  2  3  7 
 Enter Key to find : 7

 Key is found at position 5
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 Enter total number of numbers : 6

 Enter Numbers : 9
8
4
5
7
6

 Your Numbers :  9  8  4  5  7  6 
 Enter Key to find : 1

 Key is not found ! 
(base) mansi@mansi-Vostro-15-3568:~$ 

*/
