package project;
import java.util.Scanner;
import program1.BuyException;
import program1.Absentexception;
import project.Loginpage;

class NotSufficientMoneyexception extends Exception
{
	NotSufficientMoneyexception(String s)
	{
		super(s);
	}
}

class checkmoney
{

	checkmoney(int pocket,int price)throws NotSufficientMoneyexception
	{
		if(price<pocket)
			throw new NotSufficientMoneyexception("Sry You don't have sufficient balance quantity to buy!");
	}
}

class ShopName extends Thread
{ 
	String dsply;
	Thread t;
	
 ShopName(String Str)
 {
	 super("Name_Thread");
//	 object = obj;
	 t= new Thread(this);
	 dsply=Str;
	 t.start();
 }
 public synchronized void run()
 {
	 {
//		 object.NameBoard(dsply);
		 try
		 {
			 System.out.print(dsply+" ");
			 Thread.sleep(1000);
		 }
		 catch(Exception exp)
	 {
		 System.out.println(exp);
	 }
	 }
 }
 
	
}

class Addproducts implements InterAdmin
{
	Scanner sc = new Scanner (System.in);
	String Name;
	String details;
	float rate;
	int quantity;
	int ch;
	

	public void Addproducts1(int number)
	{
		ch = number;
		if(ch==1)
		{
		System.out.println("Enter Product Name");
		this.Name=sc.nextLine();
		System.out.println("Enter Product Details");
		this.details=sc.nextLine();
		System.out.println("Enter Rate/unit");
		this.rate=sc.nextFloat();
		System.out.println("Enter Available quantity");
		this.quantity=sc.nextInt();
		}
	}
	
	public void display()
	{	
	//System.out.print(i);
	System.out.print("    ");
	System.out.printf("%-15s",this.Name);
	System.out.print("      ");
	System.out.printf("%-10s",this.details);
	System.out.print("      ");
	System.out.print(this.rate);
	System.out.print("   	 ");
	System.out.println(this.quantity);
	}
	
	void show(Addproducts obj[])
	{
		for(int i=0;i<10;i++)
		{
			System.out.print(i+1);
			obj[i].display();
		}
	}
}

class cartdis extends Addproducts
{
	int num;
	void cartdis1(int n)
	{
		num = n;
	}
	void show(int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(i);
		}
	}
	
	void show(Addproducts obj[])
	{
		for(int i=0;i<num;i++)
		{
			System.out.print(i+1);
			obj[i].display();
		}
		System.out.println("");
	}
}

class cart1 extends program1.BuyException
{
	Scanner sc = new Scanner (System.in);
	int num;
	private int pur;
	int arr11[];
	int quant11[];
	
	cart1(int n,Addproducts obj1[],int arr1[],int quant1[],int number)
	{
	{
	//super.cartdis1(n);
	num = n;
	//super.show(obj1);
	quant1=new int[num];
	arr1=new int[num];
	arr11=new int[num];
	quant11=new int[num];
	System.out.println("Enter number of Items you want to purchace");
	int m = sc.nextInt();
	pur=m;
	//System.out.println("Enter Items you want to purchace");
	for(int i=0;i<m;i++)
	{
		Addpurchase(n,obj1,i,arr1,quant1);
	}
	purchasedisplay(obj1,arr1,quant1,m);

	}
	}
	
	void Addpurchase(int number,Addproducts obj[],int i,int arr11[],int quant11[])
	{
		quant11[i]=0;
		do
		{
		System.out.println("Add Your purchase item sl.no");
		arr11[i]=sc.nextInt();
		try
		{
			//BuyException objA1 = new BuyException(number,arr11[i]);
			//objA1.
			super.BuyException1(number,arr11[i]);
		}
		catch(Absentexception exp)
		{
			System.out.println("ERORR!!!");
			System.out.println(exp.getMessage());
			System.out.println("Available Products are: "+number);
		}
		//System.out.println("");
		}while(number<arr11[i]);
		do
		{
		System.out.println("Quantity That You want to buy");
		quant11[i]= sc.nextInt();
		try
		{
			checkmoney object = new checkmoney(quant11[i],obj[arr11[i]-1].quantity);
		
		}
		catch (NotSufficientMoneyexception ex)
		{
			System.out.println("ERORR!!!");
			System.out.println(ex.getMessage());
			System.out.println("You have remainimg balance of Quantity: "+(obj[arr11[i]-1].quantity));
		}
		System.out.println("");
		
		}while(obj[arr11[i]-1].quantity - quant11[i]<0);
		
	}
	
	void purchasedisplay(Addproducts obj[],int arr11[],int quant11[],int m)
	{
		System.out.println("Productname       quantity");
	for(int i=0;i<m;i++)
	{
		
		System.out.println(obj[arr11[i]-1].Name+"      "+quant11[i]);
	}
	Billing(obj,arr11,quant11);
	}
	
	void Billing(Addproducts obj[],int arr11[],int quant11[])
	{
		float sum=0;
		System.out.println("");
		System.out.println("Details Product Purchased::");
		System.out.printf("%-5s%-15s%-15s%-15s%-7s\n","SL","NAME","QUANTITY","RATE/PC","TOTAL");
		for(int i=0;i<pur;i++)
		{
			System.out.print(i+1);
			System.out.print("    ");
			System.out.printf("%-15s",obj[arr11[i]-1].Name);
			//System.out.print("    ");
			System.out.print(quant11[i]);
			System.out.print("     	    ");
			System.out.print(obj[arr11[i]-1].rate);
			System.out.print("          ");
			System.out.println(obj[arr11[i]-1].rate*quant11[i]);
			sum=sum+(obj[arr11[i]-1].rate*quant11[i]);
			obj[arr11[i]-1].quantity =	obj[arr11[i]-1].quantity - quant11[i];
		}
		System.out.println("");
		System.out.println("Total Amount that You Have To pay:"+sum);
		System.out.println("");
}
}

public class Admin{

	public static void main(String[] args) 
	{
		
		System.out.println("This program is written by");
		System.out.println("Gajanan Laxmeesh Bhat, 4NI19IS031, B SECTION");
		System.out.println("");
	//	Shop objShop= new Shop();
		ShopName Shopobj1= new ShopName("Wellcome to");
		try
		{
			Shopobj1.t.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("ERORR!");
			System.out.println(e);
		}
		ShopName Shopobj2 = new ShopName("SUPERMART");
		try
		{
			Shopobj2.t.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("ERORR!");
			System.out.println(e);
		}
		
		ShopName Shopobj3 = new ShopName("Shoping");
		try
		{
			Shopobj3.t.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("ERORR!");
			System.out.println(e);
		}
		
		
		System.out.println("");
		System.out.println("");
		Loginpage Lobj = new Loginpage();
		Lobj.Login();
		Scanner sc = new Scanner(System.in);
		int ch =1;
		System.out.println("Enter the number of Products");
		int num = sc.nextInt();
		Addproducts[] obj=new Addproducts[num];
		int quant[]=new int[num];
		int arr[]=new int[num];
		System.out.println("Enter the details of Products");
		int i=0;
		for(i=0;i<num;i++)
		
		{
			System.out.println("Product: "+(i+1));
			obj[i]=new Addproducts();
			obj[i].Addproducts1(ch);
			
		}
		
		cartdis obj1 = new cartdis();
		obj1.cartdis1(num);
		int n =1;
		while(n==1)
		{
			System.out.println("");
			System.out.println("Products in our store:");
			System.out.printf("%-5s%-20s%-15s%-15s%-7s\n","SL","NAME","DETAILS","RATE/PC","AvailableQuantity");
			obj1.show(obj);
		cart1 obj2 = new cart1(num,obj,arr,quant,ch);
		//int buy = obj2.cart11();
		System.out.println("Enter 1 to continue");
		n = sc.nextInt();
		}

		
	}
}


