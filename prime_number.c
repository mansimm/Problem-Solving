#include<stdio.h>
#include<math.h>
int main()
{
	int n;
	int flag=0;
	printf("\n	Enter number : ");
	scanf("%d",&n);

	for(int i=2;i<=n/2;i++)
	{
		if(n%i==0)
		{
			printf("\n	%d is a not a prime number !",n);
			flag=1;
			break;
		}
	}
	if(flag==0)
	{
		printf("\n	%d is a prime number...",n);
	}
}
/*
	OUTPUT
(base) mansi@mansi-Vostro-15-3568:~$ gcc prime_number.c
(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Enter number : 27

	27 is a not a prime number !(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Enter number : 3

	3 is a prime number...(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Enter number : 11

	11 is a prime number...(base) mansi@mansi-Vostro-15-3568:~$ ./a.out

	Enter number : 55

	55 is a not a prime number !(base) mansi@mansi-Vostro-15-3568:~$ 




*/
