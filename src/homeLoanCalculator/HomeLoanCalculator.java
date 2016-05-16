package homeLoanCalculator;

import java.text.NumberFormat;
import java.util.*;


public class HomeLoanCalculator {

	public static void main(String[] args) 
	{

	    System.out.println("Welcome to the Home Loan Calculator!");
	    System.out.println();

	    Scanner sc = new Scanner(System.in);
	    String choice = "y";
	    while (!choice.equalsIgnoreCase("n"))
	    {
	   System.out.println("Below we will ask you to input your loan information. Please be sure to enter the correct amounts\n"
	   		+ "to ensure accurate results are given.\n");
	   double loanAmount = getDoubleWithinRange(sc, "Enter loan amount: ", 0, 1000000);
	   double interestRate = getDoubleWithinRange(sc, "Enter yearly interest rate: ", 0, 20);
	   int years = getIntWithinRange(sc, "Enter number of years: ", 0, 100);

	   double monthlyInterestRate = interestRate/12/100;
	   int months = years * 12; 
	   double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, months);


	   NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
	   NumberFormat percent = NumberFormat.getPercentInstance();
	   percent.setMinimumFractionDigits(1);

	   String results = "Loan amount: \t\t" + currency.format(loanAmount) + "\n"
	           + "Yearly interest rate: \t" + percent.format(interestRate/100) + "\n"
	           + "Number of years: \t" + years + "\n"
	           + "Monthly payment: \t" + currency.format(monthlyPayment) + "\n";

	   System.out.println();
	   System.out.println("YOUR RESULTS");
	   System.out.println(results);


	   System.out.print("Continue? (y/n): ");
	        choice = sc.nextLine();
	        while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
	        {
	             if (choice.equals(""))
	             {
	                System.out.println("You must input a value. Try again!");
	                System.out.print("Continue? (y/n): ");
	             }
	             else
	             {
	                  System.out.println("Entry must be 'y' or 'n'. Try again.");
	                  System.out.print("Continue? (y/n): ");
	             }
	            choice = sc.nextLine();
	        }

	        }

	        }
	        public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max)
	{
	double d = 0.0;
	boolean isValid = false; 
	while (isValid == false)
	{
	    d = getDouble(sc, prompt);
	    if (d <=min) {
	        System.out.println("Try again! Number must be greater than " + min + ".");
	    }
	    else if (d >= max) {
	        System.out.println("Try again! Number must be less than " + max + ".");
	    }
	    else {
	        isValid = true;
	    }
	}
	return d; 
	}
	public static double getDouble(Scanner sc, String prompt)
	{
	double d = 0.0;
	boolean isValid = false;
	while (isValid == false)
	{
	    System.out.print(prompt);
	    if (sc.hasNextDouble())
	    {
	        d = sc.nextDouble();
	                isValid = true;
	    }
	    else
	    {
	        System.out.println("Invalid decimal value. Try Again.");
	    }
	    sc.nextLine();
	}
	 return d; 
	}
	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max)
	{
	int i = 0;
	boolean isValid = false;
	while (isValid == false)
	{
	    i = getInt(sc, prompt);
	    if (i <= min) {
	        System.out.println("Try again! Number must be greater than " + min + ".");
	    }
	    else if (i >= max) {
	        System.out.println("Try again! Number must be less than " + max + ".");
	    }
	    else {
	        isValid = true;
	    }
	}
	return i; 
	}
	public static int getInt(Scanner sc, String prompt)
	{
	int i = 0;
	boolean isValid = false;
	while (isValid == false)
	{
	    System.out.print(prompt);
	    if(sc.hasNextInt())
	    {
	        i = sc.nextInt();
	        isValid = true;
	    }
	    else 
	    {
	        System.out.println("Invalid integer value. Try again.");
	    }
	    sc.nextLine();
	}
	return i;

	}
	 public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, double months)
	 {
	double monthlyPayment = 0;
	for (int i = 1; i <= months; i++)
	{
	    monthlyPayment = loanAmount * monthlyInterestRate/(1 - 1/Math.pow(1 + monthlyInterestRate, months));
	}
	return monthlyPayment;
	}

	}		