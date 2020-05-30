import java.util.*;

class Account
{
	//static member
	public static int count;
	//private members
	private int id;
	private String name;
	private int account_number;
	private double balance;

	//parameterised constructor
	public Account(int id,String name,int account_number,double balance)
	{
		this.id=id;
		this.name=name;
		this.account_number=account_number;
		this.balance=balance;
		count++;
	}

	//public getters and setters
	public void set_id(int id)
	{
		this.id=id;
	}
	public int get_id()
	{
		return id;
	}
	public void set_name(String name)
	{
		this.name=name;
	}
	public String get_name()
	{
		return name;
	}
	public void set_account_number(int account_number)
	{
		this.account_number=account_number;
	}
	public int get_account_number()
	{
		return account_number;
	}
	public void set_balance(double balance)
	{
		this.balance=balance;
	}
	public double get_balance()
	{
		return balance;
	}

	//methods
	public static void view_balance(Account account[],int x)
	{
		int flag=0;
		for(int i=0;i<count;i++)
		{
			if(account[i].get_account_number()==x)
			{
				flag=1;
				System.out.println("Your balance is :"+account[i].get_balance());
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("  Invallide account number !");
		}
	}
	public static void deposite(Account account[],int x,int y)
	{
		int flag=0;
		for(int i=0;i<count;i++)
		{
			if(account[i].get_account_number()==y)
			{
				flag=1;
				account[i].set_balance(account[i].get_balance()+x);
				System.out.println(x+" Amount deposited...\nYour balance is :"+account[i].get_balance());
				break;
			}

		}
		if(flag==0)
		{
			System.out.println("  Invallide account number !");
		}
	}
	public static void withdraw(Account account[],int x,int y)
	{
		int flag=0;
		for(int i=0;i<count;i++)
		{
			if(account[i].get_account_number()==y)
			{
				flag=1;
				if(account[i].get_balance()>x)
				{
					account[i].set_balance(account[i].get_balance()-x);
					System.out.println(x+" Amount withdrawed...\nYour balance is :"+account[i].get_balance());
				}
				else
				{
					System.out.println(" You dont have sufficiate balance to withdraw !");
				}
				break;	
			}

		}
		if(flag==0)
		{
			System.out.println("  Invallide account number !");
		}
	}
	public static void show(Account account[])
	{
		for(int i=0;i<count;i++)
		{
			System.out.println("		account "+i);
			System.out.println("	id : "+account[i].get_id());
			System.out.println("  	name : "+account[i].get_name());
			System.out.println("  	account number : "+account[i].get_account_number());
			System.out.println("  	balance : "+account[i].get_balance());
		}
		
	}
}


public class class_demo
{

	public static void main(String args[])
	{
		int id;
		String name;
		int account_number;
		double balance;

		Scanner sc=new Scanner(System.in);
		Account account[]=new Account[10];
		int choise=1,x,y;
		while(choise!=5)
		{
			System.out.println("\n\n ---------------------------------------------------------\n");
			System.out.println("		Welcome");
			System.out.println("\n	1) Create account");
			System.out.println("\n	2) Deposite");
			System.out.println("\n	3) Withdrow");
			System.out.println("\n	4) Check Balance");
			System.out.println("\n	5) Exit");
			System.out.println("\n     Enter your choise : ");

			choise=sc.nextInt();

			switch(choise)
			{
				case 1: System.out.println("\n  Enter data(id,name,account no,balance) : ");
					id=sc.nextInt();sc.nextLine();
					name=sc.nextLine();
					account_number=sc.nextInt();sc.nextLine();
					balance=sc.nextDouble();

					account[Account.count]=new Account(id,name,account_number,balance);
					break;

				case 2: System.out.println("\n	Enter amount to deposite : ");
					x=sc.nextInt();
					System.out.println("\n	Enter account number : ");
					y=sc.nextInt();
					Account.deposite(account,x,y);
					break;

				case 3: System.out.println("\n	Enter amount to withdraw : ");
					x=sc.nextInt();
					System.out.println("\n	Enter account number : ");
					y=sc.nextInt();
					Account.withdraw(account,x,y);
					break;

				case 4: System.out.println("\n	Enter account number : ");
					y=sc.nextInt();
					Account.view_balance(account,y);
					break;

				case 5: System.out.println("\n\n	Thank you ! \n");
					break;

				case 6: Account.show(account);
					break;
				default: System.out.println("\n	Please enter vallide choise ..............");
				
			}
		}


	}

}

/*

(base) mansi@mansi-Vostro-15-3568:~$ javac class_demo.java
(base) mansi@mansi-Vostro-15-3568:~$ java class_demo


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
1

  Enter data(id,name,account no,balance) : 
1
jack
11
1000


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
1

  Enter data(id,name,account no,balance) : 
2
micky
22
2000


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
1

  Enter data(id,name,account no,balance) : 
3
mini
33
3000


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
2

	Enter amount to deposite : 
200

	Enter account number : 
22
200 Amount deposited...
Your balance is :2200.0


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
3

	Enter amount to withdraw : 
500

	Enter account number : 
33
500 Amount withdrawed...
Your balance is :2500.0


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
4

	Enter account number : 
11
Your balance is :1000.0


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
4

	Enter account number : 
33
Your balance is :2500.0


 ---------------------------------------------------------

		Welcome

	1) Create account

	2) Deposite

	3) Withdrow

	4) Check Balance

	5) Exit

     Enter your choise : 
5


	Thank you ! 

(base) mansi@mansi-Vostro-15-3568:~$ 

*/
