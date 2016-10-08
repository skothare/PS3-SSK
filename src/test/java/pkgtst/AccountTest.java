package pkgtst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pkgMain.Account;
import pkgMain.InsufficientFundsException;
 
/**
 * 
 * @author skothare
 *
 */
public class AccountTest{
	
	
	Account account = new Account(1122, 20000.00);
	
	
	/**
	 * Tests if the withdraw method successfully withdraws from the account and updates it.
	 * @throws InsufficientFundsException
	 */
	@Test
	public final void testWithdraw() throws InsufficientFundsException{
		account.setAnnualInterestRate(0.045);
		assertTrue(account.getBalance() - 2500.00 == account.withdraw(2500.00));
		System.out.println("The Account balance after deducting $2500 is $ " + account.getBalance());
		System.out.println("The Monthly Interest Rate is " + account.getMonthlyInterestRate() + " or " + account.getMonthlyInterestRate()*100+ "%");
		System.out.println("The date this account was created is " + account.getDateCreated());
	}
	
	@Test(expected = InsufficientFundsException.class)
	public final void testOverdraw() throws InsufficientFundsException{
		account.withdraw(40000);
		fail("Expected an InsufficientFundsException to be thrown");
	}
	
	
	@Test
	public final void testGetBalance() throws InsufficientFundsException{
		assertTrue(account.getBalance() == account.withdraw(0));
	}
	

	@Test
	public final void testdeposit() {
		
		assertTrue(account.getBalance() + 3000.00 == account.deposit(3000.00));
		assertFalse(account.getBalance() + 4000.02 == account.deposit(4000.00));
	}
	
	@Test
	public final void testGetNumber() {
		assertTrue( account.getId() == 1122 );
		assertFalse( account.getId() == 1112 );
	}

}