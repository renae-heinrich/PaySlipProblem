//# Basic Payslip Challenge
//
//        At MYOB we rock at payroll, the most important part of payroll is getting your payslip!
//
//        ## Overview
//
//        We have the following payslip rules:
//
//        * Pay period = per calendar month
//        * Gross income = annual salary / 12 months
//        * Income tax = based on the tax table provided below
//        * Net income = gross income - income tax
//        * Super = gross income x super rate
//        * All calculation results should be rounded to the whole dollar. If >= 50 cents round up to the next dollar increment, otherwise round down.
//
//        When supplied employee details: first name, last name, annual salary (positive integer) and super rate (0% - 50% inclusive), payment start date, generate pay slip information with name, pay period,
//        gross income, income tax, net income and super.
//
//        The following rates for 2017-18 apply from 1 July 2017:
//
//        | Taxable Income     | Tax on this Income                         |
//        |--------------------|--------------------------------------------|
//        | $0 - $18,200       | Nil                                        |
//        | $18,201 - $37,000  | 19c for each $1 over $18,200               |
//        | $37,001 - $87,000  | $3,572 plus 32.5c for each $1 over $37,000 |
//        | $87,001 - $180,000 | $19,822 plus 37c for each $1 over $87,000  |
//        | $180,001 and over  | $54,232 plus 45c for each $1 over $180,000 |
//
//        For example, the payment in March for an employee with an annual salary of $60,050 and a super rate of 9% is:
//
//        * pay period = Month of March (01 March to 31 March)
//        * gross income = 60,050 / 12 = 5,004.16666667 (round down) = 5,004
//        * income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922
//        * net income = 5,004 - 922 = 4,082
//        * super = 5,004 x 9% = 450.36 (round down) = 450
//
//        ### Your Task
//
//        Generate a basic payslip application. You should be able to enter a single employee details, the application will generate a basic payslip.
//
//        Everything will be done via the console.
//
//        An example run through of of how this console would be...
//
//        ~~~
//        Welcome to the payslip generator!
//
//        Please input your name: John
//        Please input your surname: Doe
//        Please enter your annual salary: 60050
//        Please enter your super rate: 9
//        Please enter your payment start date: 1 March
//        Please enter your payment end date: 31 March
//
//        Your payslip has been generated:
//
//        Name: John Doe
//        Pay Period: 01 March – 31 March
//        Gross Income: 5004
//        Income Tax: 922
//        Net Income:4082
//        Super: 450
//
//        Thank you for using MYOB!
//        ~~~

import models.Employee;
import models.TaxBracket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("~~~\nWelcome to the payslip generator!\n\n");

        System.out.print("Please input your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please input your surname: ");
        String surname = scanner.nextLine();

        System.out.print("Please enter your annual salary: ");
        double annualSalary = Double.parseDouble(scanner.nextLine());

        System.out.print("Please enter your super rate: ");
        double superRate = Double.parseDouble(scanner.nextLine());

        System.out.print("Please enter your payment start date: ");
        String startDate = scanner.nextLine();

        System.out.print("Please enter your payment end date: ");
        String endDate = scanner.nextLine();

        Employee employee1 = new Employee(firstName, surname, annualSalary, superRate, startDate, endDate);

        TaxBracket taxBracket1 = new TaxBracket(0, 18200, 0);
        TaxBracket taxBracket2 = new TaxBracket(18201, 37000, 0.19);
        TaxBracket taxBracket3 = new TaxBracket(37001, 87000, 0.325);
        TaxBracket taxBracket4 = new TaxBracket(87001, 180000, 0.37);
        TaxBracket taxBracket5 = new TaxBracket(180001, Double.POSITIVE_INFINITY, 0.45);

        BigDecimal grossIncome = BigDecimal.valueOf(annualSalary/12).setScale(0, RoundingMode.HALF_UP);


        System.out.print("\n" +
                "Your payslip has been generated:\n" +
                "\n" +
                "Name: " + employee1.getFirstName() + employee1.getSurname() +
                "\nPay Period: " + employee1.getStartDate() + " - " + employee1.getEndDate() +
                "\nGross Income: " + grossIncome + "\n");

        // want to put into function - need help

        BigDecimal incomeTax, netIncome;

        if (annualSalary >= taxBracket1.getLowTaxBracket() && annualSalary <= taxBracket1.getHighTaxBracket()) {
            incomeTax = new BigDecimal(0);
            System.out.println("Income Tax: " + incomeTax);
        } else if (annualSalary >= taxBracket2.getLowTaxBracket() && annualSalary <= taxBracket2.getHighTaxBracket()) {
            incomeTax = BigDecimal.valueOf(((annualSalary - taxBracket1.getHighTaxBracket()) * taxBracket2.getRate()) / 12).setScale(0, RoundingMode.HALF_UP);
            System.out.println("Income Tax: " + incomeTax);
        } else if (annualSalary >= taxBracket3.getLowTaxBracket() && annualSalary <= taxBracket3.getHighTaxBracket()) {
            incomeTax = BigDecimal.valueOf((3572 + ((annualSalary - taxBracket2.getHighTaxBracket()) * taxBracket3.getRate())) / 12).setScale(0, RoundingMode.HALF_UP);
            System.out.println("Income Tax: " + incomeTax);
        } else if (annualSalary >= taxBracket4.getLowTaxBracket() && annualSalary <= taxBracket4.getHighTaxBracket()) {
            incomeTax = BigDecimal.valueOf((19822 + ((annualSalary - taxBracket3.getHighTaxBracket()) * taxBracket4.getRate())) / 12).setScale(0, RoundingMode.HALF_UP);
            System.out.println("Income Tax " + incomeTax);
        } else {
            incomeTax = BigDecimal.valueOf((54232 + ((annualSalary - taxBracket4.getHighTaxBracket()) * taxBracket5.getRate())) / 12).setScale(0, RoundingMode.HALF_UP);
            System.out.println("Income Tax " + incomeTax);
        }
        //define tax bracket class like employee
        //BigDecimal deals with money
        netIncome = grossIncome.subtract(incomeTax);

        System.out.println("Net Income: " + netIncome);

        BigDecimal superannuation = new BigDecimal(superRate/100).multiply(grossIncome).setScale(0, RoundingMode.HALF_UP);

        System.out.println("Super: " + superannuation + "\n\nThank you for using MYOB!\n~~~");



        }





    }





