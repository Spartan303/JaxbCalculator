package com.netpace.jtc.api;


// assumption: works on yearly values
public interface TaxAPI {

//////////////// Tax Calculations and Intermediate Calculations  /////////////////

	//  Taxable Income after allowable deductions
	double getTaxableIncome(double income, double zakat);
	
	//  Income after increase
	double getExpectedIncome(double income, double increase);

	//  Expected Taxable Income after expected increase
	double getExpectedTaxableIncome(double income, double increase, double zakat);

	//  Increase in Taxable Income
	double getIncreaseInTaxableIncome(double oldTaxableIncome, double newTaxableIncome);

	//  Total tax payable
	double getTax(double taxableIncome);
	
	//  Increase in Tax after expected increase
	double getIncreaseInTax(double oldTax, double newTax);

	// Take home salary
	double getTakeHomeIncome(double taxableIncome, double tax);

	//  Increase in take home Income
	double getIncreaseInTakeHomeIncome(double oldTakeHomeIncome, double newTakeHomeIncome);

	// Average rate of Tax
	double getAvgRateOfTax(double tax, double taxableIncome);
	
	//  Tax Saving
	double getTaxSaving(double zakatDeduction, double donationDeduction, double sharesInsuranceDeduction, double pensionFundDeduction, double houseLoanInterestDeduction);
	
	//  Actual Tax
	double getActualTax(double tax, double taxSaving);

	//  Tax Saving Percent
	double getTaxSavingPercent(double actualTax, double tax);

	//  Total Tax Payable after planning
	double getPlannedTax(double tax, double actualTax);
	

////////////// Plan To Save Tax Calculations (yearly)   ///////////////

	//  Zakat deductions
	double getZakatDeduction(double zakat, double taxableIncome);

	//  Charitable Donation Deductions
	double getDonationDeduction(double donation, double taxableIncome, double avgRateofTax);

	//  Shares and Insurance Premium deductions
	double getSharesInsuranceDeduction(double shares, double insurancePremium, double taxableIncome, double avgRateofTax);
	
	//  Pension fund deductions
	double getPensionFundDeduction(double pensionFund, int age, double taxableIncome, double avgRateofTax);	

	// double House loan interest deductions
	double getHouseLoanInterestDeduction(double houseLoanInterest, double taxableIncome, double avgRateofTax);
}
