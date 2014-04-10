package com.netpace.jtc.api;

public abstract class TaxAPI {

	
	// abstract methods
	
	
	abstract TaxResult calculateTaxPlanning(double income,
			double zakat, double donation, double shares,
			double insurancePremium, double pensionFund, int age,
			double houseLoanInterest, InputType inputType);
	
	abstract TaxResult calculateTax(double income, InputType inputType);
	
	abstract TaxResult calculateImpactOfIncrement(double income, double increase, InputType inputType);
	
	// //////////// Plan To Save Tax Calculations (yearly) ///////////////

	// Total tax payable
	abstract void calcTax(TaxResult result);
	
	// Zakat deductions
	abstract void calcZakatDeduction(TaxResult result);

	// Charitable Donation Deductions
	abstract void calcDonationDeduction(TaxResult result);

	// Shares and Insurance Premium deductions
	abstract void calcSharesInsuranceDeduction(TaxResult result);

	// Pension fund deductions
	abstract void calcPensionFundDeduction(TaxResult result);

	// House loan interest deductions
	abstract void calcHouseLoanInterestDeduction(TaxResult result);
	
	// Protected Utility Methods
	protected double toYearly(double monthly) {
		return monthly * 12;
	}

	protected double toMonthly(double yearly) {

		return Math.round(yearly / 12);
	}

}
