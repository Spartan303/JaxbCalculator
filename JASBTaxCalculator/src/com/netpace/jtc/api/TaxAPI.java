package com.netpace.jtc.api;

public interface TaxAPI {

//////////////// Tax Calculations and Intermediate Calculations  /////////////////

	//  Taxable Income after allowable deductions
	double getMonthlyTaxableIncome(double income, double zakat);
	double getAnnualTaxableIncome(double income, double zakat);
	
	//  Taxable Income after increase
	double getMonthlyExpectedIncome(double income, double increase);
	double getAnnualExpectedIncome(double income, double increase);

	//  Expected Taxable Income after expected increase
	double getMonthlyExpectedTaxableIncome(double income, double increase, double zakat);
	double getAnnualExpectedTaxableIncome(double income, double increase, double zakat);

	//  Increase in Taxable Income
	double getMonthlyIncreaseInTaxableIncome(double oldTaxableIncome, double newTaxableIncome);
	double getAnnualIncreaseInTaxableIncome(double oldTaxableIncome, double newTaxableIncome);

	//  Total tax payable
	double getMonthlyTax(double taxableIncome);
	double getAnnualTax(double taxableIncome);
	
	//  Total tax payable after expected increase
	double getMonthlyExpectedTax(double newTaxableIncome);
	double getAnnualExpectedTax(double newTaxableIncome);
	
	//  Increase in Tax after expected increase
	double getMonthlyIncreaseInTax(double oldTax, double newTax);
	double getAnnualIncreaseInTax(double oldTax, double newTax);

	// Take home salary
	double getMonthlyTakeHomeIncome(double taxableIncome, double tax);
	double getAnnualTakeHomeIncome(double taxableIncome, double tax);
	
	// Expected Take home salary
	double getMonthlyExpectedTakeHomeIncome(double newTaxableIncome, double newTax);
	double getAnnualExpectedTakeHomeIncome(double newTaxableIncome, double newTax);

	//  Increase in take home Income
	double getMonthlyIncreaseInTakeHomeIncome(double oldTakeHomeIncome, double newTakeHomeIncome);
	double getAnnualIncreaseInTakeHomeIncome(double oldTakeHomeIncome, double newTakeHomeIncome);

	// Average rate of Tax
	double getAvgRateOfTax(double tax, double taxableIncome);

	// double Average rate of tax after expected increase
	double getExpectedAvgRateOfTax(double newTax, double newTaxableIncome);
	
	//  Tax Saving
	double getMonthlyTaxSaving(double zakat, double donation, double shares, double insurance, double pensionFund, double age, double houseLoanInterest);
	double getAnnualTaxSaving(double zakat, double donation, double shares, double insurance, double pensionFund, double age, double houseLoanInterest);
	
	//  Actual Tax
	double getMonthlyActualTax(double tax, double taxSaving);
	double getAnnualActualTax(double tax, double taxSaving);

	//  Tax Saving Percent
	double getMonthlyTaxSavingPercent(double actualTax, double tax);
	double getAnnualTaxSavingPercent(double actualTax, double tax);

	//  Total Tax Payable after planning
	double getMonthlyPlannedTax(double tax, double taxSaving);
	double getAnnualPlannedTax(double tax, double taxSaving);
	
	//  Total Expected Tax Payable after planning
	double getMonthlyExpectedPlannedTax(double newTax, double taxSaving);
	double getAnnualExpectedPlannedTax(double newTax, double taxSaving);

////////////// Plan To Save Tax Calculations (yearly)   ///////////////

	//  Zakat deductions
	double getZakatDeduction(double zakat);

	//  Charitable Donation Deductions
	double getDonationDeduction(double donation);

	//  Shares and Insurance Premium deductions
	double getSharesInsuranceDeduction(double shares, double insurancePremium);
	
	//  Pension fund deductions
	double getPensionFundDeduction(double pensionFund, int age);	

	// double House loan interest deductions
	double getHouseLoanInterestDeduction(double houseLoanInterest);
}
