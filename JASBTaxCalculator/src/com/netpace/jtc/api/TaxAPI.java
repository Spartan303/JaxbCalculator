package com.netpace.jtc.api;

public interface TaxAPI {

//////////////// Tax Calculations and Intermediate Calculations  /////////////////

	//  Taxable Income after allowable deductions
	double getTaxableIncomeMonthly(double income, double zakat);
	double getTaxableIncomeYearly(double income, double zakat);
	
	//  Income after increase
	double getExpectedIncomeMonthly(double income, double increase);
	double getExpectedIncomeYearly(double income, double increase);

	//  Expected Taxable Income after expected increase
	double getExpectedTaxableIncomeMonthly(double income, double increase, double zakat);
	double getExpectedTaxableIncomeYearly(double income, double increase, double zakat);

	//  Increase in Taxable Income
	double getIncreaseInTaxableIncomeMonthly(double oldTaxableIncome, double newTaxableIncome);
	double getIncreaseInTaxableIncomeYearly(double oldTaxableIncome, double newTaxableIncome);

	//  Total tax payable
	double getTaxMonthly(double taxableIncome);
	double getTaxYearly(double taxableIncome);
	
	//  Total tax payable after expected increase
	double getExpectedTaxMonthly(double newTaxableIncome);
	double getExpectedTaxYearly(double newTaxableIncome);
	
	//  Increase in Tax after expected increase
	double getIncreaseInTaxMonthly(double oldTax, double newTax);
	double getIncreaseInTaxYearly(double oldTax, double newTax);

	// Take home salary
	double getTakeHomeIncomeMonthly(double taxableIncome, double tax);
	double getTakeHomeIncomeYearly(double taxableIncome, double tax);
	
	// Expected Take home salary
	double getExpectedTakeHomeIncomeMonthly(double newTaxableIncome, double newTax);
	double getExpectedTakeHomeIncomeYearly(double newTaxableIncome, double newTax);

	//  Increase in take home Income
	double getIncreaseInTakeHomeIncomeMonthly(double oldTakeHomeIncome, double newTakeHomeIncome);
	double getIncreaseInTakeHomeIncomeYearly(double oldTakeHomeIncome, double newTakeHomeIncome);

	// Average rate of Tax
	double getAvgRateOfTax(double tax, double taxableIncome);

	// double Average rate of tax after expected increase
	double getExpectedAvgRateOfTax(double newTax, double newTaxableIncome);
	
	//  Tax Saving
	double getTaxSavingMonthly(double zakatDeduction, double donationDeduction, double sharesInsuranceDeduction, double pensionFundDeduction, double houseLoanInterestDeduction);
	double getTaxSavingYearly(double zakatDeduction, double donationDeduction, double sharesInsuranceDeduction, double pensionFundDeduction, double houseLoanInterestDeduction);
	
	//  Actual Tax
	double getActualTaxMonthly(double tax, double taxSaving);
	double getActualTaxYearly(double tax, double taxSaving);

	//  Tax Saving Percent
	double getTaxSavingPercentMonthly(double actualTax, double tax);
	double getTaxSavingPercentYearly(double actualTax, double tax);

	//  Total Tax Payable after planning
	double getPlannedTaxMonthly(double tax, double taxSaving);
	double getPlannedTaxYearly(double tax, double taxSaving);
	
	//  Total Expected Tax Payable after planning
	double getExpectedPlannedTaxMonthly(double newTax, double taxSaving);
	double getExpectedPlannedTaxYearly(double newTax, double taxSaving);

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
