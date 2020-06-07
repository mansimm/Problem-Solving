#include<iostream>
#include<math.h>
using namespace std;

void bin_to_dec(int bin)
{
	int i=0,r=0,dec=0;
	int n=bin;
	while(n!=0)
	{
		r=n%10;
		dec=r*pow(2,i)+dec;
		n=n/10;
		i++;
	}
	cout<<"\n Decimal of binary "<<bin<<" is : "<<dec;
	
	cout<<"\n\n";

}
int main()
{
	int n;
	cout<<"\n	Binary to Decimal conversion";
	cout<<"\n\n Enter binary number : ";
	cin>>n;
	bin_to_dec(n);
	return 0;
}

/*
	Output :

(base) mansi@mansi-Vostro-15-3568:~$ g++ binary_to_decimal.cpp
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Binary to Decimal conversion

 Enter binary number : 1000

 Decimal of binary 1000 is : 8

(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Binary to Decimal conversion

 Enter binary number : 0

 Decimal of binary 0 is : 0

(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Binary to Decimal conversion

 Enter binary number : 1

 Decimal of binary 1 is : 1

(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Binary to Decimal conversion

 Enter binary number : 10

 Decimal of binary 10 is : 2

(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Binary to Decimal conversion

 Enter binary number : 1010

 Decimal of binary 1010 is : 10

(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Binary to Decimal conversion

 Enter binary number : 1111

 Decimal of binary 1111 is : 15

(base) mansi@mansi-Vostro-15-3568:~$ 





*/
