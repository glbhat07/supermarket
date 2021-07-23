package program1;
import program1.Absentexception;

public class BuyException {
	public void BuyException1(int pocket,int price)throws Absentexception
	{
		if(price>pocket)
			throw new Absentexception("Sry Product Not there!");
	}
}
