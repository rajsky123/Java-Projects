package Business;

import org.springframework.stereotype.Component;

import Exception.ActNoInvalid;
@Component("bank")
public class Bank implements BankInterface  {

	private int amt=5000;
	private String actno="sbi123";
	
	/* (non-Javadoc)
	 * @see Business.BankInterface#deposit(java.lang.String, int)
	 */
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
	
	/* (non-Javadoc)
	 * @see Business.BankInterface#checkBalance(java.lang.String)
	 */
	public int checkBalance(String actno) throws ActNoInvalid
	{
		if(this.actno.equals(actno))
		return this.amt;
		else
			throw new ActNoInvalid();
		
	}
	
}
