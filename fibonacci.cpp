/*

Fibonacci number

Description
In mathematics, the Fibonacci numbers, commonly denoted Fₙ, form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
*/

#include<iostream>
using namespace std;

void fibbo(int n)
{
	int a=0,b=1,c;
	int i=2;
	cout<<"  "<<a<<"  "<<b;
	while(i!=n)
	{
		c=a+b;
		cout<<"  "<<c;
		a=b;
		b=c;
		i++;
	}


}

int main()
{
	int n;
	cout<<"\n 	Fibonacci series\n";
	cout<<"\n Enter the number of terms : ";
	cin>>n;
	cout<<"\n "<<n<<" terms of fibbonacci series are : ";
	fibbo(n);
	cout<<"\n";
	return 0;
}

/* Output


(base) mansi@mansi-Vostro-15-3568:~$ g++ fibonacci.cpp
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 	Fibonacci series

 Enter the number of terms : 20

 20 terms of fibbonacci series are :   0  1  1  2  3  5  8  13  21  34  55  89  144  233  377  610  987  1597  2584  4181
(base) mansi@mansi-Vostro-15-3568:~$ ^C


*/
