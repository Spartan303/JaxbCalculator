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
		String choice = "";
		
		do {
			
			testcase.printMainMenu();
			choice = testcase.inputString();
			
			switch (choice) {
			case "1":
				testcase.calculateTax(InputType.MONTHLY);
				break;
			case "2":
				testcase.calculateTax(InputType.YEARLY);
				break;
			case "3":
				testcase.calculateImpactOfIncrement(InputType.MONTHLY);
				break;
			case "4":
				testcase.calculateImpactOfIncrement(InputType.YEARLY);
				break;
			case "5":
				testcase.planToSaveTax();
				break;
			case "6":
				System.exit(0);
				break;
			default:
				break;
			}
			
		} while(choice != "6");
	}
	
	private void calculateTax(InputType inputType) {
		
		resetInputs();
		inputIncome(inputType);
		
		TaxResult result = TCManager.getInstance().calculateTax(income, inputType, TaxAPIType.SALARIED, 2014);
		
		System.out.println("Taxable Salary Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Salary Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Take Home Salary Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Salary Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax() + "%");
	}
	
	private void calculateImpactOfIncrement(InputType inputType) {
		
		resetInputs();
		inputIncome(inputType);
		inputIncrease(inputType);
		
		TaxResult result = TCManager.getInstance().calculateImpactOfIncrement(income, increase, inputType, TaxAPIType.SALARIED, 2014);
		
		System.out.println("Taxable Salary Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Salary Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Expected Taxable Salary Yearly : " + result.getExpectedTaxableIncomeYearly());
		System.out.println("Expected Taxable Salary Monthly : " + result.getExpectedTaxableIncomeMonthly());
		
		System.out.println("Increase In Taxable Salary Yearly : " + result.getIncreaseInTaxableIncomeYearly());
		System.out.println("Increase In Taxable Salary Monthly : " + result.getIncreaseInTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Total Expected Tax Payable Yearly : " + result.getExpectedTaxYearly());
		System.out.println("Total Expected Tax Payable Monthly : " + result.getExpectedTaxMonthly());
		
		System.out.println("Increase In Tax Payable Yearly : " + result.getIncreaseInTaxYearly());
		System.out.println("Increase In Tax Payable Monthly : " + result.getIncreaseInTaxMonthly());
		
		System.out.println("Take Home Salary Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Salary Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Expected Take Home Salary Yearly : " + result.getExpectedTakeHomeIncomeYearly());
		System.out.println("Expected Take Home Salary Monthly : " + result.getExpectedTakeHomeIncomeMonthly());
		
		System.out.println("Increase In Take Home Salary Yearly : " + result.getIncreaseInTakeHomeIncomeYearly());
		System.out.println("Increase In Take Home Salary Monthly : " + result.getIncreaseInTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax() + "%");
		
		System.out.println("Expected Average Rate of Tax : " + result.getExpAvgRateOfTax() + "%");
		
	}
	
	private void planToSaveTax() {
		resetInputs();
		
		inputIncome(InputType.YEARLY);
		
		inputZakat();
		inputDonation();
		inputShares();
		inputInsurance();
		inputAge();
		inputPension();
		inputHouseLoanInterest();
		
		
		TaxResult result = TCManager.getInstance().calculateTaxPlanning(income, 
				zakat, donation, shares, insurancePremium, 
				pensionFund, age, houseLoanInterest, InputType.YEARLY, 
				TaxAPIType.SALARIED, 2014);
		
		System.out.println("Salary Yearly : " + result.getUiIncomeYearly());
		System.out.println("Salary Monthly : " + result.getUiIncomeMonthly());
		
		System.out.println("Taxable Salary Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Salary Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Take Home Salary Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Salary Monthly : " + result.getTakeHomeIncomeMonthly());
		
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
		
		System.out.println("::::::::::::::: Income Tax Calculator ::::::::::::::");
		
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
			System.out.println("Enter Yearly Salary :  ");
		} else if (inputType == InputType.MONTHLY) {
			System.out.println("Enter Monthly Salary :  ");
		}
		
		income = inputDouble();
	}
	
	private void inputIncrease(InputType inputType) {
		
		if(inputType == InputType.YEARLY) {
			System.out.println("Enter Yearly Salary :  ");
		} else if (inputType == InputType.MONTHLY) {
			System.out.println("Enter Monthly Salary :  ");
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
