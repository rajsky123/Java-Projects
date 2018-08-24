package Business;

import Exception.ActNoInvalid;

public interface BankInterface {

	int deposit(String actno, int amt) throws ActNoInvalid;

	int checkBalance(String actno) throws ActNoInvalid;

}