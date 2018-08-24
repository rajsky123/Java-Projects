package Business;

import org.springframework.stereotype.Component;

import Exception.ActNoInvalid;
@Component
public class Bank {

	private int amt=5000;
	private String actno="sbi123";
	
	public int deposit(String actno,int amt) throws ActNoInvalid
	{
		if(this.actno.equals(actno))
		{
			System.out.println("deposit method....");
			this.amt+=amt;
			return this.amt;
		}
		else
		throw new ActNoInvalid();
	}
	
	public int checkBalance(String actno) throws ActNoInvalid
	{
		if(this.actno.equals(actno))
		return this.amt;
		else
			throw new ActNoInvalid();
		
	}
}
