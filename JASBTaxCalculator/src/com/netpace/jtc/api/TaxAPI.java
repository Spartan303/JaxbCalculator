package com.netpace.jtc.api;

public abstract class TaxAPI {

	
	// public abstract methods
	
	public abstract TaxResult calculateTaxPlanning(Double income,
			Double zakat, Double donation, Double shares,
			Double insurancePremium, Double pensionFund, int age,
			Double houseLoanInterest, InputType inputType);
	
	public abstract TaxResult calculateTax(Double income, InputType inputType);
	
	public abstract TaxResult calculateImpactOfIncrement(Double income, Double increase, InputType inputType);
	
// 	========================  Plan To Save Tax Calculations (yearly) ============================

	// Total tax payable
	public abstract void calcTax(TaxResult result);
	
	// Zakat deductions 
	public abstract void calcZakatDeduction(TaxResult result);

	// Charitable Donation Deductions
	public abstract void calcDonationDeduction(TaxResult result);

	// Shares and Insurance Premium deductions
	public abstract void calcSharesInsuranceDeduction(TaxResult result);

	// Pension fund deductions
	public abstract void calcPensionFundDeduction(TaxResult result);

	// House loan interest deductions
	public abstract void calcHouseLoanInterestDeduction(TaxResult result);
	
// 	=====================  Protected Utility Methods  =====================================
	
	protected Double toYearly(Double monthly) {
		return monthly * 12;
	}

	protected Double toMonthly(Double yearly) {

		return (double) Math.round(yearly / 12);
	}

}
