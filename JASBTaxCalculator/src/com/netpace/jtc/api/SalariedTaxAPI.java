package com.netpace.jtc.api;

public class SalariedTaxAPI extends TaxAPI {

	@Override
	public double getTax(double taxableIncome) {

		return 0;
	}

	@Override
	public TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, InputType inputType) {
		TaxResult result = getTaxCalculationResult(income, increase, zakat, 0,
				0, 0, 0, 0, 0, inputType);

		return result;
	}

	@Override
	public TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, double donation, double shares,
			double insurancePremium, double pensionFund, int age,
			double houseLoanInterest, InputType inputType) {

		// old means without increase in income
		// new means after increase in income

		TaxResult result = new TaxResult();

		double yIncome = 0;
		double mIncome = 0;
		double yIncrease = 0;
		double mIncrease = 0;

		if (inputType == inputType.MONTHLY) {
			yIncome = toYearly(income);
			mIncome = income;
		} else {
			yIncome = income;
			mIncome = toMonthly(income);
		}
		
		
		// Taxable Salary after zakat allowable deduction
		double yOldTaxableIncome = getTaxableIncome(income, zakat);
		double mOldTaxableIncome = toMonthly(yOldTaxableIncome);
		result.setTaxableIncomeYearly(yOldTaxableIncome);
		result.setTaxableIncomeMonthly(mOldTaxableIncome);

		// Taxable Salary after increase and alloawable deduction
		double yNewTaxableIncome = getExpectedTaxableIncome(income, increase,
				zakat);
		double mNewTaxableIncome = toMonthly(yNewTaxableIncome);
		result.setExpectedTaxableIncomeYearly(yNewTaxableIncome);
		result.setExpectedTaxableIncomeMonthly(mNewTaxableIncome);

		// Increase in taxabe income after expected increase
		double yIncreaseInTaxableIncome = getIncreaseInTaxableIncome(
				yOldTaxableIncome, yNewTaxableIncome);
		double mIncreaseInTaxableIncome = toMonthly(yIncreaseInTaxableIncome);
		result.setIncreaseInTaxableIncomeYearly(yIncreaseInTaxableIncome);
		result.setIncreaseInTaxableIncomeMonthly(mIncreaseInTaxableIncome);

		// Total Tax Payable 
		double yOldTax = getTax(yOldTaxableIncome);
		double mOldTax = toMonthly(yOldTax);
		result.setTaxYearly(yOldTax);
		result.setTaxMonthly(mOldTax);

		// Total Tax Payable after expected increase
		double yNewTax = getTax(yNewTaxableIncome);
		double mNewTax = getTax(yNewTax);
		result.setExpectedTaxYearly(yNewTax);
		result.setExpectedTaxMonthly(mNewTax);

		// Increase in tax after expected Increase
		double yIncreaseInTax = getIncreaseInTax(yOldTax, yNewTax);
		double mIncreaseInTax = toMonthly(yIncreaseInTax);
		result.setIncreaseInTaxYearly(yIncreaseInTax);
		result.setIncreaseInTaxMonthly(mIncreaseInTax);

		
		// Take Home Income
		double yOldTakeHomeIncome = getTakeHomeIncome(yOldTaxableIncome, yOldTax);
		double mOldTakeHomeIncome = toMonthly(yOldTakeHomeIncome);
		result.setTakeHomeIncomeYearly(yOldTakeHomeIncome);
		result.setTakeHomeIncomeMonthly(mOldTakeHomeIncome);
		
		// Expected Take Home Income after expected increase
		double yNewTakeHomeIncome = getTakeHomeIncome(yNewTaxableIncome, yNewTax);
		double mNewTakeHomeIncome = toMonthly(yNewTakeHomeIncome);
		result.setExpectedTakeHomeIncomeYearly(yNewTakeHomeIncome);
		result.setExpectedTakeHomeIncomeMonthly(mNewTakeHomeIncome);

		// Increase in take home income after expected increase
		double yIncreaseInTakeHomeIncome = getIncreaseInTakeHomeIncome(
				yOldTakeHomeIncome, yNewTakeHomeIncome);
		double mIncreaseInTakeHomeIncome = toMonthly(yIncreaseInTakeHomeIncome);
		result.setIncreaseInTakeHomeIncomeYearly(yIncreaseInTakeHomeIncome);
		result.setIncreaseInTakeHomeIncomeMonthly(mIncreaseInTakeHomeIncome);

		// Avg Rate of tax
		double avgRateofTax = getAvgRateOfTax(yOldTax, yOldTaxableIncome);
		result.setAvgRateOfTax(avgRateofTax);

		// Avg rate of tax after expected increase
		double newAvgRateofTax = getAvgRateOfTax(yNewTax, yNewTaxableIncome);
		result.setExpAvgRateOfTax(newAvgRateofTax);

		// zakat amount waiver using formula 
		double zakatDeduction = getZakatDeduction(zakat, yOldTaxableIncome);
		result.setZakatDeduction(zakatDeduction);

		// donation amount waiver using formula
		double donationDeduction = getDonationDeduction(donation,
				yOldTaxableIncome, newAvgRateofTax);
		result.setDonationDeduction(donationDeduction);

		// pension fund investment waiver using formula
		double pensionFundDeduction = getPensionFundDeduction(pensionFund, age,
				yOldTaxableIncome, newAvgRateofTax);
		result.setPensionDeduction(pensionFundDeduction);

		// shares and insurance investment waiver using formula
		double sharesInsuranceDeduction = getSharesInsuranceDeduction(shares,
				insurancePremium, mOldTaxableIncome, newAvgRateofTax);
		result.setShares_InsuranceDeduction(sharesInsuranceDeduction);

		// house loan interest amount waiver using formula
		double houseLoanInterestDeduction = getHouseLoanInterestDeduction(
				houseLoanInterest, mOldTaxableIncome, newAvgRateofTax);
		result.setHouseLoanInterestDeduction(houseLoanInterestDeduction);

		// total tax saving
		double taxSaving = getTaxSaving(zakatDeduction, donationDeduction,
				sharesInsuranceDeduction, pensionFundDeduction,
				houseLoanInterestDeduction);
		result.setTotalTaxSaving(taxSaving);

		// actual tax 
		double actualTax = getActualTax(yOldTax, taxSaving);
		result.setActualTaxPayable(actualTax);

		// Tax Saving Percentage
		double taxSavingPercent = getTaxSavingPercent(actualTax, yOldTax);
		result.setTaxSavingPercent(taxSavingPercent);  

		// Tax Payable after Planning
		double yOldPlannedTax = getPlannedTax(yOldTax, actualTax);
		double mOldPlannedTax = toMonthly(yOldPlannedTax);
		result.setPlannedTaxYearly(yOldPlannedTax);
		result.setPlannedTaxMonthly(mOldPlannedTax);

		// Tax Payable after Planning and expected increase in salary 
		double yNewPlannedTax = getPlannedTax(yNewTax, actualTax);
		double mNewPlannedTax = toYearly(yNewPlannedTax);
		result.setPlannedTaxYearly(mNewPlannedTax);
		result.setPlannedTaxMonthly(mNewPlannedTax);
	
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
