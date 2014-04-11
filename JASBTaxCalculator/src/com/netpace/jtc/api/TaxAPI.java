package com.netpace.jtc.api;

public abstract class TaxAPI {

	
	// abstract methods
	
	
	abstract TaxResult calculateTaxPlanning(Double income,
			Double zakat, Double donation, Double shares,
			Double insurancePremium, Double pensionFund, int age,
			Double houseLoanInterest, InputType inputType);
	
	abstract TaxResult calculateTax(Double income, InputType inputType);
	
	abstract TaxResult calculateImpactOfIncrement(Double income, Double increase, InputType inputType);
	
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
	protected Double toYearly(Double monthly) {
		return monthly * 12;
	}

	protected Double toMonthly(Double yearly) {

		return (double) Math.round(yearly / 12);
	}

}
