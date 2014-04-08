package com.netpace.jtc.api;

public class SalariedTaxAPI implements TaxAPI {

	@Override
	public double getTaxableIncome(double income, double zakat) {
		return income-zakat;
	}

	@Override
	public double getExpectedIncome(double income, double increase) {
		return income+increase;
	}

	@Override
	public double getExpectedTaxableIncome(double income, double increase,
			double zakat) {

		return income+increase-zakat;
	}

	@Override
	public double getIncreaseInTaxableIncome(double oldTaxableIncome,
			double newTaxableIncome) {

		return newTaxableIncome-oldTaxableIncome;
	}

	@Override
	public double getTax(double taxableIncome) {
		
//		Slab slab = findSlab();
//		logic to calc tax using slab
		return 0;
	}

	@Override
	public double getIncreaseInTax(double oldTax, double newTax) {

		return newTax-oldTax;
	}

	@Override
	public double getTakeHomeIncome(double taxableIncome, double tax) {

		return taxableIncome-tax;
	}

	@Override
	public double getIncreaseInTakeHomeIncome(double oldTakeHomeIncome,
			double newTakeHomeIncome) {

		return newTakeHomeIncome-oldTakeHomeIncome;
	}

	@Override
	public double getAvgRateOfTax(double tax, double taxableIncome) {

		return Math.round(tax/taxableIncome);
	}

	@Override
	public double getTaxSaving(double zakatDeduction, double donationDeduction,
			double sharesInsuranceDeduction, double pensionFundDeduction,
			double houseLoanInterestDeduction) {

		double taxSaving = 	zakatDeduction + 
							donationDeduction + 
							sharesInsuranceDeduction + 
							pensionFundDeduction + 
							houseLoanInterestDeduction;
		
		return taxSaving;
	}

	@Override
	public double getActualTax(double tax, double taxSaving) {

		return Math.min(tax, taxSaving);
	}

	@Override
	public double getTaxSavingPercent(double actualTax, double tax) {

		return actualTax/tax * 100;
	}

	@Override
	public double getPlannedTax(double tax, double actualTax) {

		return tax-actualTax;
	}

	@Override
	public double getZakatDeduction(double zakat, double taxableIncome) {
		return Math.min(zakat, taxableIncome);
	}
	
	@Override
	public double getDonationDeduction(double donation, double taxableIncome,
			double avgRateofTax) {

		// Limit 1: Amount of donation = a 
		// Limit 2: 30% of taxable income = b
		// Formula: MIN(a, b) * avgRateofTax
		
		return Math.min(donation, 0.3*taxableIncome) * avgRateofTax;
	}

	@Override
	public double getSharesInsuranceDeduction(double shares,
			double insurancePremium, double taxableIncome, double avgRateofTax) {

		// Limit 1: Amount of Shares + Insurance = a 
		// Limit 2: 20% of taxable income = b
		// Limit 3: 1 Million per year = c
		// Formula: MIN(a, b, c) * avgRateofTax
		
		double amountOfSharesAndInsurance = shares + insurancePremium;
		double taxableIncomePart = taxableIncome * 0.2;
		double CONSTANT_LIMIT = 1000000; // 1 million 
		
		return Math.min(amountOfSharesAndInsurance, Math.min(taxableIncomePart, CONSTANT_LIMIT)) * avgRateofTax;
	}

	@Override
	public double getPensionFundDeduction(double pensionFund, int age,
			double taxableIncome, double avgRateofTax) {

		// Limit 1: Amount of Contribution in Pension Fund = a 
		// Limit 2: 20% of taxable income = b (if age <= 40)
		// Formula: MIN(a, b) * avgRateofTax
		
		int limit = 20; // 20%
		double taxableIncomePart = taxableIncome * ((double) limit/100);
		
		// limit 2 increased by 2% each year for age > 40
		if(age >= 40) {
			limit = limit + 2 * (age - 40);
			taxableIncomePart = taxableIncome * ((double) limit/100);
		}
		
		return Math.min(pensionFund, taxableIncomePart) * avgRateofTax;
	}

	@Override
	public double getHouseLoanInterestDeduction(double houseLoanInterest,
			double taxableIncome, double avgRateofTax) {

		// Limit 1: Amount of Interest on House Loan = a 
		// Limit 2: 50% of taxable income = b
		// Limit 3: 75,000 per year
		// Formula: MIN(a, b, c) * avgRateofTax
		
		double taxableIncomePart = taxableIncome * 0.5;
		double CONSTANT_LIMIT = 1000000; // 1 million 
		
		return Math.min(houseLoanInterest, Math.min(taxableIncomePart, CONSTANT_LIMIT)) * avgRateofTax;
	}

}
