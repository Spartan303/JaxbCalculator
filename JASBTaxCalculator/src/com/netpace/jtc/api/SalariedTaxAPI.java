package com.netpace.jtc.api;

public class SalariedTaxAPI extends TaxAPI {

	@Override
	public TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, InputType inputType) {
		
		TaxResult result = getTaxCalculationResult(income, increase, zakat, 0,
				0, 0, 0, 0, 0, inputType);

		return result;
	}

	// Input Type Only Decides income and increase values to be monthly and yearly 
	@Override
	public TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, double donation, double shares,
			double insurancePremium, double pensionFund, int age,
			double houseLoanInterest, InputType inputType) {

// 		old means without increase in income
// 		new means after increase in income
		
// =================================== Declaration Section With default values =========================================================
		
//		inputs
		double yIncome = 0;
		double mIncome = 0;
		double yIncrease = 0;
		double mIncrease = 0;
		
		
//		With increase		
		double yNewTaxableIncome = 0;
		double mNewTaxableIncome = 0;
		double yIncreaseInTaxableIncome = 0;
		double mIncreaseInTaxableIncome = 0;
		double yNewTax = 0;
		double mNewTax = 0;
		double yIncreaseInTax = 0;
		double mIncreaseInTax = 0;
		double yNewTakeHomeIncome = 0;
		double mNewTakeHomeIncome = 0;
		double yIncreaseInTakeHomeIncome = 0;
		double mIncreaseInTakeHomeIncome = 0;
		double newAvgRateofTax = 0;
		
//		Plan to save Tax	
		double zakatDeduction = 0;
		double donationDeduction = 0;
		double pensionFundDeduction = 0;
		double sharesInsuranceDeduction = 0;
		double houseLoanInterestDeduction = 0;

//		Analysis after planning		
		double taxSaving = 0;
		double actualTax = 0;
		double taxSavingPercent = 0;
		double yOldPlannedTax = 0;
		double mOldPlannedTax = 0;
		double yNewPlannedTax = 0;
		double mNewPlannedTax = 0;

//	============================== Congfiguring inputs monthly and yearly  =====================================		

		// Input Type Only Decides income and increase values to be monthly and yearly   
		if (inputType == InputType.MONTHLY) {
			yIncome = toYearly(income); // 60,000
			mIncome = income; // 50,000
			
			yIncrease = toYearly(increase); // 0
			mIncrease = increase; // 0
			
		} else {
			
			yIncome = income;
			mIncome = toMonthly(income);
			
			yIncrease = increase;
			mIncrease = toMonthly(increase);
		}
		
		
// ================================ Without Increase Calculation Section   =======================================
		
		// Taxable Salary after zakat allowable deduction
		double yOldTaxableIncome = yIncome - zakat;  // 500,000 
		double mOldTaxableIncome = toMonthly(yOldTaxableIncome); // 41,667

		
		// Total Tax Payable 
		double yOldTax = getTax(yOldTaxableIncome); // 5000
		double mOldTax = toMonthly(yOldTax); // 417

		
		// Take Home Income
		double yOldTakeHomeIncome = yOldTaxableIncome - yOldTax;  // 495,000
		double mOldTakeHomeIncome = toMonthly(yOldTakeHomeIncome); // 41,250

		
		// Avg Rate of tax
		double avgRateofTax = yOldTax/yOldTaxableIncome; // 1.00%

			
// ============================= With Increase Calculation Section  =================================
		
		if(yIncrease > 0) {
			
			// Taxable Salary after increase and alloawable deduction
			yNewTaxableIncome = getExpectedTaxableIncome(yIncome, yIncrease, zakat); 
			mNewTaxableIncome = toMonthly(yNewTaxableIncome); 
	
	
			// Increase in taxabe income after expected increase
			yIncreaseInTaxableIncome = getIncreaseInTaxableIncome(
					yOldTaxableIncome, yNewTaxableIncome);
			mIncreaseInTaxableIncome = toMonthly(yIncreaseInTaxableIncome);
	
	
			// Total Tax Payable after expected increase
			yNewTax = getTax(yNewTaxableIncome); 
			mNewTax = getTax(yNewTax);
	
	
			// Increase in tax after expected Increase
			yIncreaseInTax = getIncreaseInTax(yOldTax, yNewTax);
			mIncreaseInTax = toMonthly(yIncreaseInTax);
	
			
			// Expected Take Home Income after expected increase
			yNewTakeHomeIncome = getTakeHomeIncome(yNewTaxableIncome, yNewTax);
			mNewTakeHomeIncome = toMonthly(yNewTakeHomeIncome);
	
	
			// Increase in take home income after expected increase
			yIncreaseInTakeHomeIncome = getIncreaseInTakeHomeIncome(
					yOldTakeHomeIncome, yNewTakeHomeIncome);
			mIncreaseInTakeHomeIncome = toMonthly(yIncreaseInTakeHomeIncome);
	
	
			// Avg rate of tax after expected increase
			newAvgRateofTax = getAvgRateOfTax(yNewTax, yNewTaxableIncome);
		
		}
		
		else {
			yNewTaxableIncome = yOldTaxableIncome;
			mNewTaxableIncome = mOldTaxableIncome;
			
			yNewTax = yOldTax;
			mNewTax = mOldTax;
			
			yNewTakeHomeIncome = yOldTakeHomeIncome;
			mNewTakeHomeIncome = mOldTakeHomeIncome;
			
			newAvgRateofTax = avgRateofTax;
			
			// increase in taxable income, tax and take home income will be zero as new and old values are same;
		}
			
		
// ============================== Plan to Save Tax Calculation Section  =================================		
		
		if (zakat > 0) {
			// zakat amount waiver using formula 
			zakatDeduction = getZakatDeduction(zakat, yOldTaxableIncome);
		}

		if (donation > 0) {
			// donation amount waiver using formula
			donationDeduction = getDonationDeduction(donation,
					yOldTaxableIncome, avgRateofTax);
		}
		
		if (pensionFund > 0 ) {
			// pension fund investment waiver using formula
			pensionFundDeduction = getPensionFundDeduction(pensionFund, age,
					yOldTaxableIncome, avgRateofTax);
		}
		

		if (shares > 0 || insurancePremium > 0) {
			// shares and insurance investment waiver using formula
			sharesInsuranceDeduction = getSharesInsuranceDeduction(shares,
					insurancePremium, mOldTaxableIncome, avgRateofTax);
		}
		
		if(houseLoanInterest > 0) {
			// house loan interest amount waiver using formula
			houseLoanInterestDeduction = getHouseLoanInterestDeduction(
					houseLoanInterest, mOldTaxableIncome, avgRateofTax);
		}
		

// =================================== Analysis Calculation Section   =======================================
		// total tax saving
		taxSaving = getTaxSaving(zakatDeduction, donationDeduction,
				sharesInsuranceDeduction, pensionFundDeduction,
				houseLoanInterestDeduction);
		

		// actual tax 
		actualTax = getActualTax(yOldTax, taxSaving); // 0
		
		// Tax Saving Percentage
		taxSavingPercent = getTaxSavingPercent(actualTax, yOldTax); // 0
		
		// Tax Payable after Planning
		yOldPlannedTax = getPlannedTax(yOldTax, actualTax); // 5000
		mOldPlannedTax = toMonthly(yOldPlannedTax); // 417

		// Tax Payable after Planning and expected increase in salary 
		yNewPlannedTax = getPlannedTax(yNewTax, actualTax); // 5000
		mNewPlannedTax = toYearly(yNewPlannedTax); // 417

//=============================  Setter Section  ===================================================
//		Set all the tax calculation results in result object to return		
		
		TaxResult result = new TaxResult();

		//	UI input values				
		result.setUiIncomeMonthly(mIncome); 
		result.setUiIncomeYearly(yIncome); 
		result.setUiMonthlyExpectedIncrease(mIncrease);    
		result.setUiYearlyExpectedIncrease(yIncrease); 
		result.setUiZakat(zakat); 
		result.setUiInsurance(insurancePremium);  
		result.setUiShares(shares); 
		result.setUiDonation(donation); 
		result.setUiPension(pensionFund);
		result.setUiHouseLoanInterest(houseLoanInterest);

		//	without increase in income
		result.setTaxableIncomeYearly(yOldTaxableIncome);
		result.setTaxableIncomeMonthly(mOldTaxableIncome); 
		result.setTaxYearly(yOldTax);
		result.setTaxMonthly(mOldTax);
		result.setTakeHomeIncomeYearly(yOldTakeHomeIncome); 
		result.setTakeHomeIncomeMonthly(mOldTakeHomeIncome);
		result.setAvgRateOfTax(avgRateofTax); 
		
		//	With Increase in income
		result.setExpectedTaxableIncomeYearly(yNewTaxableIncome); 
		result.setExpectedTaxableIncomeMonthly(mNewTaxableIncome);
		result.setIncreaseInTaxableIncomeYearly(yIncreaseInTaxableIncome);  
		result.setIncreaseInTaxableIncomeMonthly(mIncreaseInTaxableIncome);
		result.setExpectedTaxYearly(yNewTax);
		result.setExpectedTaxMonthly(mNewTax);
		result.setIncreaseInTaxYearly(yIncreaseInTax);
		result.setIncreaseInTaxMonthly(mIncreaseInTax);
		result.setExpectedTakeHomeIncomeYearly(yNewTakeHomeIncome);
		result.setExpectedTakeHomeIncomeMonthly(mNewTakeHomeIncome);
		result.setIncreaseInTakeHomeIncomeYearly(yIncreaseInTakeHomeIncome);
		result.setIncreaseInTakeHomeIncomeMonthly(mIncreaseInTakeHomeIncome);
		result.setExpAvgRateOfTax(newAvgRateofTax);
		
		// Plan to save Tax
		result.setZakatDeduction(zakatDeduction);
		result.setDonationDeduction(donationDeduction);
		result.setPensionDeduction(pensionFundDeduction);
		result.setShares_InsuranceDeduction(sharesInsuranceDeduction);
		result.setHouseLoanInterestDeduction(houseLoanInterestDeduction);
		
		// Analysis
		result.setTotalTaxSaving(taxSaving);
		result.setActualTaxPayable(actualTax);
		result.setTaxSavingPercent(taxSavingPercent);  
		result.setPlannedTaxYearly(yOldPlannedTax);
		result.setPlannedTaxMonthly(mOldPlannedTax);
		result.setPlannedTaxYearly(mNewPlannedTax);
		result.setPlannedTaxMonthly(mNewPlannedTax);
		
// =============================================================================================

		return result;
	}
// 	=========================== Tax Calculation ============================
	
	@Override
	public double getTax(double taxableIncome) {
		
		// Slab slab = findSlab(taxableIncome);	// actual line 
		Slab slab = new Slab(400001d, 75000d, 0d, 5f); // just for testing
		
		if (slab != null) {
			double offset = slab.getOffsetValue();
			double percent = slab.getPercentValue();
			double exceedAmount = taxableIncome - slab.getStartValue();
			double tax = offset + (exceedAmount *  percent);
			
			return tax;
		}
		
		return 0;
		
	}

	
//  =============== Plan To Save Tax Formuale (yearly)  ==================

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
	@Override
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
	@Override
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
