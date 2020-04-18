/*

Concept - Static Members Difficulty Level 2

Create a class Employee with below attributes:

id - int

name - String

designation - String

ssnNo - int

age - int

salary - double

idCounter - int which is a static field and initialize to 0

Make all the attributes private.Create corresponding getters and setters.

Create a constructor which takes all parameters except the static member and the attribute id in the above sequence.
The constructor should set the value of attributes as parameter values inside the constructor.Increment the value of the static member by 1 inside the constructor and assign to the attribute id

Test from the main method by creating  5 objects of the Employee class and print the idCounter value after creation of each object

Refer below sample main method and test the output:

public class EmployeeDemo {
public static void main(String args[]){
Employee employee1= new Employee("jirhehb","siarpha",35,70,776.0);
System.out.println("Value of idCounter : " + Employee.getIdCounter());
Employee employee2= new Employee("ycrdzsi","voivkqr",32,87,484.0);
System.out.println("Value of idCounter : " + Employee.getIdCounter());
Employee employee3= new Employee("txdxrzv","azpjbbb",4,63,369.0);
System.out.println("Value of idCounter : " + Employee.getIdCounter());
Employee employee4= new Employee("pefjukm","mctpbqe",36,0,951.0);
System.out.println("Value of idCounter : " + Employee.getIdCounter());
Employee employee5= new Employee("shbrzke","lpcnymz",51,86,181.0);
System.out.println("Value of idCounter : " + Employee.getIdCounter());
}
}

Output
Value of idCounter : 1
Value of idCounter : 2
Value of idCounter : 3
Value of idCounter : 4
Value of idCounter : 5

*/
public class EmployeeDemo
{
	public static void main(String args[])
	{
		Employee employee1= new Employee("jirhehb","siarpha",35,70,776.0);
		System.out.println("Value of idCounter : " + Employee.getIdCounter());

		Employee employee2= new Employee("ycrdzsi","voivkqr",32,87,484.0);
		System.out.println("Value of idCounter : " + Employee.getIdCounter());

		Employee employee3= new Employee("txdxrzv","azpjbbb",4,63,369.0);
		System.out.println("Value of idCounter : " + Employee.getIdCounter());

		Employee employee4= new Employee("pefjukm","mctpbqe",36,0,951.0);
		System.out.println("Value of idCounter : " + Employee.getIdCounter());

		Employee employee5= new Employee("shbrzke","lpcnymz",51,86,181.0);
		System.out.println("Value of idCounter : " + Employee.getIdCounter());
	}
}

class Employee
{
	// private members declaration
	private int id;
	private String name;
	private String designation;
	private int ssnNo;
	private int age;
	private double salary;
	static int idCounter;// static member

	// parameterised constructor
	public Employee(String name,String designation,int ssnNo,int age,double salary)
	{
		this.name=name;
		this.designation=designation;
		this.ssnNo=ssnNo;
		this.age=age;
		this.salary=salary;

		this.idCounter+=1;
		this.id=this.idCounter;
	}

	// public getters and setters
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setDesignation(String designation)
	{
		this.designation=designation;
	}
	public String getDesignation()
	{
		return designation;
	}
	public void setSsnNo(int ssnNo)
	{
		this.ssnNo=ssnNo;
	}
	public int getSsnNo()
	{
		return ssnNo;
	}	
	public void setAge(int age)
	{
		this.age=age;
	}
	public int getAge()
	{
		return age;
	}
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	public double getSalart()
	{
		return salary;
	}
	public static int getIdCounter()
	{
		return idCounter;
	}
	
}
/*		Output

(base) mansi@mansi-Vostro-15-3568:~$ javac EmployeeDemo.java
(base) mansi@mansi-Vostro-15-3568:~$ java EmployeeDemo
Value of idCounter : 1
Value of idCounter : 2
Value of idCounter : 3
Value of idCounter : 4
Value of idCounter : 5
(base) mansi@mansi-Vostro-15-3568:~$ ^C

/

