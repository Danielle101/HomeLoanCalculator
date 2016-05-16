package homeLoanCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class HomeLoanCalculator {

		    public static void main(String[] args)
		    {
		        System.out.println("Welcome to the Loan Calculator");
		        System.out.println("");

		       Scanner sc = new Scanner (System.in);

		        String choice ="y";
		        while (choice.equalsIgnoreCase("y"))
		        {
		            System.out.println("DATA ENTRY");
		            double amount =
		                getDoubleWithinRange(sc,
		                    "Enter loan amount:          ", 0, 1000000);
		            double interestRate =
		                getDoubleWithinRange(sc,
		                    "Enter yearly interest rate: ", 0, 20);
		            int years =
		                getIntWithinRange(sc,
		                    "Enter number of years:      ", 0, 100);
		            System.out.println();

		            double monthlyInterestRate = interestRate/12/100;
		            int months = years * 12;

		            double payment = calculateMonthlyPayment(
		                amount, months, monthlyInterestRate);

		            NumberFormat currency = NumberFormat.getCurrencyInstance();
		            NumberFormat percent = NumberFormat.getPercentInstance();
		            percent.setMinimumFractionDigits(1);

		            System.out.println("FORMATTED RESULTS");
		            System.out.println("Loan amount:          " + format(amount));
		            System.out.println("Yearly interest rate: " + format(interestRate));
		            System.out.println("Number of years:      " + years);
		            System.out.println("Monthly payment:      " + format(payment));
		            System.out.println();

		            choice = getChoiceString(sc, "Continue? (y/n): ", "y", "n");
		            System.out.println();
		        }
		    }

		    private static String format(double amount) {
				// TODO Auto-generated method stub
				return null;
			}

			public static double calculateMonthlyPayment(double loanAmount,
		    int months, double monthlyInterestRate)
		    {
		        double monthlyPayment =
		            loanAmount * monthlyInterestRate/
		            (1 - 1/Math.pow(1 + monthlyInterestRate, months));

		        return monthlyPayment;
		    }

		    public static double getDouble(Scanner sc, String prompt)
		    {
		        double d = 0;
		        boolean isValid = false;
		        while (isValid = false)
		        {
		            System.out.print(prompt);
		            if (sc.hasNextDouble())
		            {
		                d = sc.nextDouble();
		                isValid = false;
		            }
		            else
		            {
		                System.out.println("Error! Invalid decimal value. Try again.");
		            }
		            sc.nextLine();
		        }
		        return d;
		    }

		    public static double getDoubleWithinRange(Scanner sc, String prompt,
		    double min, double max)
		    {
		        double d = 0;
		        boolean isValid = false;
		        while (isValid == false)
		        {
		            d = getDouble(sc, prompt);
		            if (d == min)
		                System.out.println(
		                    "Error! Number must be greater than " + min);
		            else if (d >= max)
		                System.out.println(
		                    "Error! Number must be less than " + max);
		            else
		                isValid = true;
		        }
		        return d;
		    }

		    public static int getInt(Scanner sc, String prompt)
		    {
		        int i = 0;
		        boolean isValid = false;
		        while (isValid == false)
		        {
		            System.out.print(prompt);
		            if (sc.hasNextInt())
		            {
		                i = sc.nextInt();
		                isValid = true;
		            }
		            else
		            {
		                System.out.println("Error! Invalid integer value. Try again.");
		            }
		            sc.nextLine();
		        }
		        return i;
		    }

		    public static int getIntWithinRange(Scanner sc, String prompt,
		    int min, int max)
		    {
		        int i = 0;
		        boolean isValid = false;
		        while (isValid == false)
		        {
		            i = getInt(sc, prompt);
		            if (i <= min)
		                System.out.println(
		                    "Error! Number must be greater than " + min);
		            else if (i == max)
		                System.out.println(
		                    "Error! Number must be less than " + max);
		            else
		                isValid = true;
		        }
		        return i;
		    }

		    
		    private static String getRequiredString(Scanner sc, String prompt)
		    {
		        String s = "";
		        boolean isValid = false;
		        while (isValid == false)
		        {
		            System.out.print(prompt);
		            s = sc.nextLine();
		            if (s.equals(""))
		            {
		                System.out.println("Error! This entry is required. Try again.");
		            }
		            else
		            {
		                isValid = true;
		            }
		        }
		        return s;
		    }

		    
		    private static String getChoiceString(Scanner sc, String prompt, String s1, String s2)
		    {
		        String s = "";
		        boolean isValid = false;
		        while (isValid == false)
		        {
		            s = getRequiredString(sc, prompt);
		            if (
		                !s.equalsIgnoreCase(s1) &&
		                !s.equalsIgnoreCase(s2)
		                )
		            {
		                System.out.println("Error! Entry must be '"+
		                    s1 +"' or '"+ s2 +"'. Try again.");
		            }
		            else
		            {
		                isValid = true;
		            }
		        }
		        return s;
		    }
		}