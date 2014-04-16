package com.netpace.jtc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.netpace.jtc.api.InputType;
import com.netpace.jtc.api.TCManager;
import com.netpace.jtc.api.TaxAPIType;
import com.netpace.jtc.api.TaxResult;

public class TestCase {

	private Double income;
	private Double increase;

	private Double zakat;
	private Double donation;
	private Double shares;
	private Double insurancePremium;
	private Double pensionFund;
	private int age;
	private Double houseLoanInterest;
	
	public static void main(String[] args) {
		
		TestCase testcase = new TestCase();
		String choice1 = "";
		String choice2 = "";
		
		do {
			
			testcase.printCategory();
			choice1 = testcase.inputString();
			
			switch (choice1) {
				case "1":
					break;
				case "2":
					break;
				default:
					System.out.println("Invalid Choice :-(");
					continue;
			}
						
			testcase.printMainMenu();
			choice2 = testcase.inputString();
			
			switch (choice2) {
				case "1":
					testcase.calculateTax(InputType.MONTHLY, choice1);
					break;
				case "2":
					testcase.calculateTax(InputType.YEARLY, choice1);
					break;
				case "3":
					testcase.calculateImpactOfIncrement(InputType.MONTHLY, choice1);
					break;
				case "4":
					testcase.calculateImpactOfIncrement(InputType.YEARLY, choice1);
					break;
				case "5":
					testcase.planToSaveTax(choice1);
					break;
				case "6":
					System.out.println("Exiting...");
					System.out.println("::::::::::Application End::::::::::");
					System.exit(0);
				default:
					System.out.println("Invalid Choice :-(");
					continue;
			}
			
		} while(true);
	}
	
	private void printCategory() {
		System.out.println("::::::::::::::: Income Tax Calculator ::::::::::::::");
		System.out.println("Select Category");
		
		System.out.println("1- Salaried");
		System.out.println("2- Non-Salaried");
	}

	private void calculateTax(InputType inputType, String choice1) {
		
		resetInputs();
		inputIncome(inputType);
		
		TaxResult result = null;
		
		if(choice1.equals("1"))
			result = TCManager.getInstance().calculateTax(income, inputType, TaxAPIType.SALARIED, 2014);
		else if(choice1.equals("2"))
			result = TCManager.getInstance().calculateTax(income, inputType, TaxAPIType.NON_SALARIED, 2014);
		
		System.out.println("Taxable Income Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Income Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Take Home Income Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Income Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax() + "%");
	}
	
	private void calculateImpactOfIncrement(InputType inputType, String choice1) {
		
		resetInputs();
		inputIncome(inputType);
		inputIncrease(inputType);
		
		TaxResult result = null;
		
		if(choice1.equals("1"))
			result = TCManager.getInstance().calculateImpactOfIncrement(income, increase, inputType, TaxAPIType.SALARIED, 2014);
		else if(choice1.equals("2"))
			result = TCManager.getInstance().calculateImpactOfIncrement(income, increase, inputType, TaxAPIType.NON_SALARIED, 2014);		
		
		System.out.println("Taxable Income Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Income Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Expected Taxable Income Yearly : " + result.getExpectedTaxableIncomeYearly());
		System.out.println("Expected Taxable Income Monthly : " + result.getExpectedTaxableIncomeMonthly());
		
		System.out.println("Increase In Taxable Income Yearly : " + result.getIncreaseInTaxableIncomeYearly());
		System.out.println("Increase In Taxable Income Monthly : " + result.getIncreaseInTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Total Expected Tax Payable Yearly : " + result.getExpectedTaxYearly());
		System.out.println("Total Expected Tax Payable Monthly : " + result.getExpectedTaxMonthly());
		
		System.out.println("Increase In Tax Payable Yearly : " + result.getIncreaseInTaxYearly());
		System.out.println("Increase In Tax Payable Monthly : " + result.getIncreaseInTaxMonthly());
		
		System.out.println("Take Home Income Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Income Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Expected Take Home Income Yearly : " + result.getExpectedTakeHomeIncomeYearly());
		System.out.println("Expected Take Home Income Monthly : " + result.getExpectedTakeHomeIncomeMonthly());
		
		System.out.println("Increase In Take Home Income Yearly : " + result.getIncreaseInTakeHomeIncomeYearly());
		System.out.println("Increase In Take Home Income Monthly : " + result.getIncreaseInTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax() + "%");
		
		System.out.println("Expected Average Rate of Tax : " + result.getExpAvgRateOfTax() + "%");
		
	}
	
	private void planToSaveTax(String choice1) {
		resetInputs();
		
		inputIncome(InputType.YEARLY);
		
		inputZakat();
		inputDonation();
		inputShares();
		inputInsurance();
		inputAge();
		inputPension();
		inputHouseLoanInterest();
		
		TaxResult result = null;
		
		if(choice1.equals("1"))
			result = TCManager.getInstance().calculateTaxPlanning(income, 
					zakat, donation, shares, insurancePremium, 
					pensionFund, age, houseLoanInterest, InputType.YEARLY, 
					TaxAPIType.SALARIED, 2014);
		else if(choice1.equals("2"))
			result = TCManager.getInstance().calculateTaxPlanning(income, 
					zakat, donation, shares, insurancePremium, 
					pensionFund, age, houseLoanInterest, InputType.YEARLY, 
					TaxAPIType.NON_SALARIED, 2014);
		
		
		System.out.println("Income Yearly : " + result.getUiIncomeYearly());
		System.out.println("Income Monthly : " + result.getUiIncomeMonthly());
		
		System.out.println("Taxable Income Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Income Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Take Home Income Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Income Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax());
		
		System.out.println("Zakat Deduction : " + result.getZakatDeduction());
		System.out.println("Donation Deduction : " + result.getDonationDeduction());
		System.out.println("Shares and Insurance Deduction : " + result.getShares_InsuranceDeduction());
		System.out.println("Pension Fund Deduction : " + result.getPensionDeduction());
		System.out.println("House Loan Interest Deduction : " + result.getHouseLoanInterestDeduction());

		System.out.println("Total Tax Saving : " + result.getTotalTaxSaving());
		System.out.println("Limited To Actual Tax Payable : " + result.getActualTaxPayable());
		System.out.println("% Tax Saving: " + result.getTaxSavingPercent() + "%");
	}
	
	private void printMainMenu() {
				
		System.out.println("Main Menu");
		
		System.out.println("1- Calculate Tax Monthly");
		System.out.println("2- Calculate Tax Yearly");
		
		System.out.println("3- Calculate Impact of Increment Monthly");
		System.out.println("4- Calculate Impact of Increment Yearly");
		
		System.out.println("5- Plan To Save Tax");
		
		System.out.println("6- Exit");
	}

	private void inputIncome(InputType inputType) {
		
		if(inputType == InputType.YEARLY) {
			System.out.println("Enter Yearly Income :  ");
		} else if (inputType == InputType.MONTHLY) {
			System.out.println("Enter Monthly Income :  ");
		}
		
		income = inputDouble();
	}
	
	private void inputIncrease(InputType inputType) {
		
		if(inputType == InputType.YEARLY) {
			System.out.println("Enter Yearly Increase In Income :  ");
		} else if (inputType == InputType.MONTHLY) {
			System.out.println("Enter Monthly Increase In Income :  ");
		}
		
		increase = inputDouble();
	}

	private void inputZakat() {
		System.out.println("Enter Amount of Zakat :  ");
		zakat = inputDouble();
	}
	
	private void inputDonation() {
		System.out.println("Enter Amount of Donation :  ");
		donation = inputDouble();
	}
	
	private void inputShares() {
		System.out.println("Enter Amount of Investment In Shares :  ");
		shares = inputDouble();
	}
	
	private void inputInsurance() {
		System.out.println("Enter Amount of Life Insurance Premium :  ");
		insurancePremium = inputDouble();
	}
	
	private void inputAge() {
		System.out.println("Enter Your Age :  ");
		age = inputInteger();
	}
	
	private void inputPension() {
		System.out.println("Enter Amount of Investment In Approved Pension Fund :  ");
		pensionFund = inputDouble();
	}
	
	private void inputHouseLoanInterest() {
		System.out.println("Enter Amount of Interest on House Loan :  ");
		houseLoanInterest = inputDouble();
	}
	
	private Double inputDouble() {
		Double inputDouble = 0d;
		
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    inputDouble = Double.parseDouble(bufferRead.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return inputDouble;
	}
	
	private Integer inputInteger() {
		Integer inputInteger = 0;
		
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    inputInteger = Integer.parseInt(bufferRead.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return inputInteger;
	}
	
	private String inputString() {
		String s = "";
		
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    s = bufferRead.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return s;		
	}

	private void resetInputs() {
		income = 0d;
		increase = 0d;

		zakat = 0d;
		donation = 0d;
		shares = 0d;
		insurancePremium = 0d;
		pensionFund = 0d;
		age = 0;
		houseLoanInterest = 0d;
	}
}
