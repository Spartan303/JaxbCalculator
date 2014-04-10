package com.netpace.jtc.api;

public abstract class TaxAPI {

	
	// abstract methods 

	abstract TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, double donation, double shares,
			double insurancePremium, double pensionFund, int age,
			double houseLoanInterest, InputType inputType);
	
	abstract TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, InputType inputType);

	// //////////// Plan To Save Tax Calculations (yearly) ///////////////

	// Zakat deductions
	abstract double getZakatDeduction(double zakat, double taxableIncome);

	// Charitable Donation Deductions
	abstract double getDonationDeduction(double donation, double taxableIncome,
			double avgRateofTax);

	// Shares and Insurance Premium deductions
	abstract double getSharesInsuranceDeduction(double shares,
			double insurancePremium, double taxableIncome, double avgRateofTax);

	// Pension fund deductions
	abstract double getPensionFundDeduction(double pensionFund, int age,
			double taxableIncome, double avgRateofTax);

	// double House loan interest deductions
	abstract double getHouseLoanInterestDeduction(double houseLoanInterest,
			double taxableIncome, double avgRateofTax);
	
	// =================================================================== 
	//     Intermediate Calculations in Tax Calculations Result			//
	// 	==================================================================

	// Taxable Income after allowable deductions
	protected double getTaxableIncome(double income, double zakat) {
		return income - zakat;
	}

	// Income after increase
	protected double getExpectedIncome(double income, double increase) {
		
		return income + increase;
	}

	// Expected Taxable Income after expected increase
	protected double getExpectedTaxableIncome(double income, double increase,
			double zakat) {

		return income + increase - zakat;
	}

	// Increase in Taxable Income
	protected double getIncreaseInTaxableIncome(double oldTaxableIncome,
			double newTaxableIncome) {

		return newTaxableIncome - oldTaxableIncome;
	}

	// Total tax payable
	abstract double getTax(double taxableIncome);

	// Increase in Tax after expected increase
	protected double getIncreaseInTax(double oldTax, double newTax) {

		return newTax - oldTax;
	}

	// Take home salary
	protected double getTakeHomeIncome(double taxableIncome, double tax) {

		return taxableIncome - tax;
	}

	// Increase in take home Income
	protected double getIncreaseInTakeHomeIncome(double oldTakeHomeIncome,
			double newTakeHomeIncome) {

		return newTakeHomeIncome - oldTakeHomeIncome;
	}

	// Average rate of Tax
	protected double getAvgRateOfTax(double tax, double taxableIncome) {

		return Math.round(tax / taxableIncome);
	}

	// Tax Saving
	protected double getTaxSaving(double zakatDeduction,
			double donationDeduction, double sharesInsuranceDeduction,
			double pensionFundDeduction, double houseLoanInterestDeduction) {

		double taxSaving = zakatDeduction + donationDeduction
				+ sharesInsuranceDeduction + pensionFundDeduction
				+ houseLoanInterestDeduction;

		return taxSaving;
	}

	// Actual Tax
	protected double getActualTax(double tax, double taxSaving) {

		return Math.min(tax, taxSaving);
	}

	// Tax Saving Percent
	protected double getTaxSavingPercent(double actualTax, double tax) {

		return actualTax / tax * 100;
	}

	// Total Tax Payable after planning
	protected double getPlannedTax(double tax, double actualTax) {

		return tax - actualTax;
	}

	// Protected Utility Methods
	protected double toYearly(double monthly) {

		return monthly * 12;
	}

	protected double toMonthly(double yearly) {

		return Math.round(yearly / 12);
	}

}
