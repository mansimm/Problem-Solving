#include<iostream>
using namespace std;

void dec_to_bin(int num)
{
	int a[20];
	int i=0,r=0,n;
	n=num;
	while(n!=0)
	{
		r=n%2;
		a[i]=r;
		n=n/2;
		i++;
	}
	cout<<"\n Binary of decimal "<<num<<" is : ";
	for(int j=i-1;j>=0;j--)
	{
		cout<<a[j];
	}
	cout<<"\n";

}
int main()
{
	int n;
	cout<<"\n	Decimal to binary conversion";
	cout<<"\n\n Enter decimal number : ";
	cin>>n;
	dec_to_bin(n);
	return 0;
}

/*
	Output :

(base) mansi@mansi-Vostro-15-3568:~$ g++ dec_to_bin.cpp
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Decimal to binary conversion

 Enter decimal number : 2

 Binary of decimal 2 is : 10
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Decimal to binary conversion

 Enter decimal number : 4

 Binary of decimal 4 is : 100
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Decimal to binary conversion

 Enter decimal number : 6

 Binary of decimal 6 is : 110
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Decimal to binary conversion

 Enter decimal number : 8

 Binary of decimal 8 is : 1000
(base) mansi@mansi-Vostro-15-3568:~$ 



*/
