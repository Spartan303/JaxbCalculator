package com.netpace.jtc.api;

public class SalariedTaxAPI extends TaxAPI {

	@Override
	public double getTax(double taxableIncome) {

		return 0;
	}

	@Override
	public TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, double donation, double shares,
			double insurancePremium, double pensionFund, int age,
			double houseLoanInterest, InputType inputType) {

		
		TaxResult result = new TaxResult();
		
		double yIncome = 0;
		double mIncome = 0;
		double yIncrease = 0;
		double mIncrease = 0;
		
		if(inputType == inputType.MONTHLY) {
			yIncome = toYearly(income);
			mIncome = income;
		} 
		else {
			yIncome = income;
			mIncome = toMonthly(income);
		}
		
		double yOldTaxableIncome = getTaxableIncome(income, zakat);
		double mOldTaxableIncome = toMonthly(yOldTaxableIncome);
		
		double yNewTaxableIncome = getExpectedTaxableIncome(income, increase, zakat);
		double mNewTaxableIncome = toMonthly(yNewTaxableIncome);
		
		double yIncreaseInTaxableIncome = getIncreaseInTaxableIncome(yOldTaxableIncome, yNewTaxableIncome);
		double mIncreaseInTaxableIncome = toMonthly(yIncreaseInTaxableIncome);
		
		double yOldTax = getTax(yOldTaxableIncome);
		double mOldTax = toMonthly(yOldTax);
		
		double yNewTax = getTax(yNewTaxableIncome);
		double mNewTax = getTax(yNewTax);
		
		double yIncreaseInTax = getIncreaseInTax(yOldTax, yNewTax);
		double mIncreaseInTax = toMonthly(yIncreaseInTax);
				
		double yOldTakeHomeIncome = getTakeHomeIncome(yOldTaxableIncome, yOldTax);
		double mOldTakeHomeIncome = toMonthly(yOldTakeHomeIncome);
		
		double yNewTakeHomeIncome = getTakeHomeIncome(yNewTaxableIncome, yNewTax);
		double mNewTakeHomeIncome = toMonthly(yNewTakeHomeIncome);
		
		double yIncreaseInTakeHomeIncome = getIncreaseInTakeHomeIncome(yOldTakeHomeIncome, yNewTakeHomeIncome);
		double mIncreaseInTakeHomeIncome = toMonthly(yIncreaseInTakeHomeIncome);
		
		double avgRateofTax = getAvgRateOfTax(yOldTax, yOldTaxableIncome);
		
		double newAvgRateofTax = getAvgRateOfTax(yNewTax, yNewTaxableIncome);
		
		// set these variables in result object
		
		return result;
		
	}

	// //////////// Plan To Save Tax Calculations (yearly) ///////////////

	// Zakat deductions
	@Override
	public double getZakatDeduction(double zakat, double taxableIncome) {

		return Math.min(zakat, taxableIncome);
	}

	// Charitable Donation Deductions
	@Override
	public double getDonationDeduction(double donation, double taxableIncome,
			double avgRateofTax) {

		// Limit 1: Amount of donation = a
		// Limit 2: 30% of taxable income = b
		// Formula: MIN(a, b) * avgRateofTax

		double taxableIncomePart = 0.3 * taxableIncome;
		return Math.min(donation, taxableIncomePart) * avgRateofTax;
	}

	// Shares and Insurance Premium deductions
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

		return Math.min(amountOfSharesAndInsurance,
				Math.min(taxableIncomePart, CONSTANT_LIMIT))
				* avgRateofTax;
	}

	// Pension fund deductions
	public double getPensionFundDeduction(double pensionFund, int age,
			double taxableIncome, double avgRateofTax) {

		// Limit 1: Amount of Contribution in Pension Fund = a
		// Limit 2: 20% of taxable income = b (if age <= 40)
		// Formula: MIN(a, b) * avgRateofTax

		int limit = 20; // 20%
		double taxableIncomePart = taxableIncome * ((double) limit / 100);

		// limit 2 increased by 2% each year for age > 40
		if (age >= 40) {
			limit = limit + 2 * (age - 40);
			taxableIncomePart = taxableIncome * ((double) limit / 100);
		}

		return Math.min(pensionFund, taxableIncomePart) * avgRateofTax;
	}

	// double House loan interest deductions
	public double getHouseLoanInterestDeduction(double houseLoanInterest,
			double taxableIncome, double avgRateofTax) {

		// Limit 1: Amount of Interest on House Loan = a
		// Limit 2: 50% of taxable income = b
		// Limit 3: 75,000 per year
		// Formula: MIN(a, b, c) * avgRateofTax

		double taxableIncomePart = taxableIncome * 0.5;
		double CONSTANT_LIMIT = 1000000; // 1 million

		return Math.min(houseLoanInterest,
				Math.min(taxableIncomePart, CONSTANT_LIMIT))
				* avgRateofTax;
	}

}
