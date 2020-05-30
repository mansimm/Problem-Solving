

#include<iostream>
using namespace std;

void pallindrom(int n)
{
	int temp=n;
	int rev=0,r;
	while(temp!=0)
	{
		r=temp%10;
		rev=rev*10+r;
		temp=temp/10;
	}

	if(rev==n)
	{
		cout<<"\n Number is pallindrom.";
	}
	else
	{
		cout<<"\n Number is not pallindrom.";
	}

}

int main()
{
	int n;
	cout<<"\n 	Pallindrom Number\n";
	cout<<"\n Enter the number : ";
	cin>>n;
	pallindrom(n);
	cout<<"\n";
	return 0;
}

/* Output
(base) mansi@mansi-Vostro-15-3568:~$ g++ pallindrom_number.cpp
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 	Pallindrom Number

 Enter the number : 12344321

 Number is pallindrom.
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 	Pallindrom Number

 Enter the number : 12543

 Number is not pallindrom.
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

 	Pallindrom Number

 Enter the number : 1234321

 Number is pallindrom.
(base) mansi@mansi-Vostro-15-3568:~$ 



*/
