package pkgMain;

import java.util.Date;

/**
 * 
 * @author skothare
 *
 */
public class Account {

	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	// A no-argument constructor to initialize the variables.
	public Account(){
		id = 0;
		balance = 0.0;
		annualInterestRate = 0.0;
		dateCreated = new Date();
		// Created a default account with the appropriate data types for the variables.
	}
	// A constructor with arguments to build an account
	public Account(int specid, double initbalance){
		this.annualInterestRate = 0.0;
		this.id = specid; // Refers to id variable from the no argument constructor
		this.balance = initbalance; //Refers to the balance from no-arg
		dateCreated = new Date();
	}
	
	// Setters and Getters created using Eclipse Generate Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	// Calculates the Monthly interest rate from the annual interest rate
	public double getMonthlyInterestRate(){
		double monthlyInterestRate = annualInterestRate/12;
		return monthlyInterestRate;
	}
	/**
	 * 
	 * @param withdrawAmt
	 * @return balance
	 * @throws InsufficientFundsException
	 */
	public double withdraw(double withdrawAmt) throws InsufficientFundsException{
		if (withdrawAmt <= balance){
			double newbalance1 = balance-withdrawAmt;
			this.balance = newbalance1;
			return balance;
		}
		else{
			double needs = withdrawAmt- balance;
			throw new InsufficientFundsException(needs);
		}
	}
	/**
	 * 
	 * @param depositAmt
	 * @return balance
	 */
	public double deposit(double depositAmt){
		double newbalance2 = balance + depositAmt;
		this.balance = newbalance2;
		return balance;
	}
	
	
	
}