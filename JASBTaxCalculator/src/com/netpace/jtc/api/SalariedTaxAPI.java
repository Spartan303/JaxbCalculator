package com.netpace.jtc.api;

public class SalariedTaxAPI extends TaxAPI {
	
	private static TaxSlabSheet slabSheet;
	static String fileName_prefix = "Slabs_S_";
	static Integer year;

// ==================== Constructor ===========================
	
	public SalariedTaxAPI(int year) {
		
		SalariedTaxAPI.year = year; // to be correct if year changed
		
		if (slabSheet == null ||  SalariedTaxAPI.year != year)
			SalariedTaxAPI.slabSheet = getSlabSheet(year);

		
	}
	
// ====================  Helper method to load sheet first time or when year is changed  ===========================
	
	private TaxSlabSheet getSlabSheet(int year) {
		
		  String sFileName = SalariedTaxAPI.fileName_prefix + SalariedTaxAPI.year.toString();
		  
		  return TaxSlabSheet.load(sFileName, year);
	}
	
// ==================== Abstract methods implementation  ===========================	
	
	@Override
	void calcZakatDeduction(TaxResult result) {
		
		Double zakat = result.getZakatDeduction();
		Double taxableIncome = result.getTaxableIncomeYearly();
		
		result.setZakatDeduction(Math.min(zakat, taxableIncome));
	}

	@Override
	void calcDonationDeduction(TaxResult result) {
		
		// Limit 1: Amount of donation = a
		// Limit 2: 30% of taxable income = b
		// Formula: MIN(a, b) * avgRateofTax
		
		Double avgRateofTax = result.getAvgRateOfTax();
		Double donation = result.getUiDonation();
		Double taxableIncome = result.getTaxableIncomeYearly();
		Double taxableIncomePart = 0.3 * taxableIncome;
		
		result.setDonationDeduction(Math.min(donation, taxableIncomePart) * avgRateofTax);		
	}

	@Override
	void calcSharesInsuranceDeduction(TaxResult result) {

		Double shares = result.getUiShares();
		Double insurancePremium = result.getUiInsurance();
		Double taxableIncome = result.getTaxableIncomeYearly();
		Double avgRateofTax = result.getAvgRateOfTax();
		
		// Limit 1: Amount of Shares + Insurance = a
		// Limit 2: 20% of taxable income = b
		// Limit 3: 1 Million per year = c
		// Formula: MIN(a, b, c) * avgRateofTax

		Double amountOfSharesAndInsurance = shares + insurancePremium;
		Double taxableIncomePart = taxableIncome * 0.2;
		Double CONSTANT_LIMIT = 1000000d; // 1 million

		Double shares_InsuranceDeduction = Math.min(amountOfSharesAndInsurance, Math.min(taxableIncomePart, CONSTANT_LIMIT)) * avgRateofTax;
		
		result.setShares_InsuranceDeduction(shares_InsuranceDeduction); 
	}

	@Override
	void calcPensionFundDeduction(TaxResult result) {

		
		Double pensionFund = result.getUiPension(); 
		int age = result.getUiAge();
		Double taxableIncome = result.getTaxableIncomeYearly(); 
		Double avgRateofTax = result.getAvgRateOfTax(); 
		
		// Limit 1: Amount of Contribution in Pension Fund = a
		// Limit 2: 20% of taxable income = b (if age <= 40)
		// Formula: MIN(a, b) * avgRateofTax

		int limit = 20; // 20%
		Double taxableIncomePart = taxableIncome * ((double) limit / 100);

		// limit 2 increased by 2% each year for age > 40
		if (age >= 40) {
			limit = limit + 2 * (age - 40);
			taxableIncomePart = taxableIncome * ((double) limit / 100);
		}

		result.setPensionDeduction(Math.min(pensionFund, taxableIncomePart) * avgRateofTax);
	}

	@Override
	void calcHouseLoanInterestDeduction(TaxResult result) {
		
		Double houseLoanInterest = result.getUiHouseLoanInterest();
		Double taxableIncome = result.getTaxableIncomeYearly(); 
		Double avgRateofTax = result.getAvgRateOfTax();

		// Limit 1: Amount of Interest on House Loan = a
		// Limit 2: 50% of taxable income = b
		// Limit 3: 75,000 per year
		// Formula: MIN(a, b, c) * avgRateofTax

		Double taxableIncomePart = taxableIncome * 0.5;
		Double CONSTANT_LIMIT = 1000000d; // 1 million
		
		Double houseLoanInterestDeduction = Math.min(houseLoanInterest,
				Math.min(taxableIncomePart, CONSTANT_LIMIT))
				* avgRateofTax;

		result.setHouseLoanInterestDeduction(houseLoanInterestDeduction);
	}

	@Override
	void calcTax(TaxResult result) {
		
		Double taxableIncome = result.getTaxableIncomeYearly();
		Double tax = getTax(taxableIncome);
		Double yTakeHomeIncome = taxableIncome - tax;
		Double avgRateOfTax = (double) Math.round(tax/taxableIncome * 100);
		
		result.setTaxYearly(tax);
		result.setTaxMonthly(toMonthly(tax));
		
		result.setTakeHomeIncomeYearly(yTakeHomeIncome);
		result.setTakeHomeIncomeMonthly( toMonthly(yTakeHomeIncome) );
		
		result.setAvgRateOfTax(avgRateOfTax);
	}

//	=============================== Private helper methods   =================================
	
	private Double getTax(Double amount) {
		// Slab slab = findSlab(taxableIncome);	// actual line 
		Slab slab = new Slab(2500001d, 3000000d, 262500d, 20f); // just for testing
		
		Double offset = slab.getOffsetValue();
		Double percent = (double) slab.getPercentValue();
		Double exceedAmount = amount - slab.getStartValue();
		Double tax = offset + exceedAmount * percent;
		
		return (double) Math.round(tax);
	}
		
	private void calcImpactOfIncrement(TaxResult result) {

		Double newTaxableIncome = result.getExpectedTaxableIncomeYearly();
		
		Double newTax = getTax(newTaxableIncome);
		Double oldTax = result.getTaxYearly();
		Double yIncreaseInTax = newTax - oldTax;
		
		Double newTakeHomeIncome = newTaxableIncome - newTax;
		Double oldTakeHomeIncome = result.getTakeHomeIncomeYearly();
		Double yIncreaseInTakeHomeIncome = newTakeHomeIncome - oldTakeHomeIncome;
		
		Double newAvgRateOfTax = (double) Math.round(newTax/newTaxableIncome * 100);
		
		result.setExpectedTaxYearly(newTax);
		result.setTaxMonthly( toMonthly(newTax) );
		
		result.setIncreaseInTaxYearly(yIncreaseInTax);
		result.setIncreaseInTaxMonthly( toMonthly(yIncreaseInTax) );
		
		result.setExpectedTakeHomeIncomeYearly(newTakeHomeIncome);
		result.setExpectedTakeHomeIncomeMonthly( toMonthly(newTakeHomeIncome) );
		
		result.setIncreaseInTakeHomeIncomeYearly(yIncreaseInTakeHomeIncome);
		result.setIncreaseInTakeHomeIncomeMonthly( toMonthly(yIncreaseInTakeHomeIncome) );
		
		result.setExpAvgRateOfTax(newAvgRateOfTax);
	}
	
	private void calcPlanning(TaxResult result) {

		calcZakatDeduction(result);
		calcDonationDeduction(result);
		calcPensionFundDeduction(result);
		calcSharesInsuranceDeduction(result);
		calcHouseLoanInterestDeduction(result);

		calcAnalysis(result);
	}
	
	private void calcAnalysis(TaxResult result) {
		Double zakatDeduction = result.getZakatDeduction();
		Double donationDeduction = result.getDonationDeduction();
		Double pensionFundDeduction = result.getPensionDeduction();
		Double sharesInsuranceDeduction = result.getShares_InsuranceDeduction();	
		Double houseLoanInterestDeduction = result.getHouseLoanInterestDeduction();
		
		Double tax = result.getTaxYearly();
		
		Double taxSaving = zakatDeduction + 
							donationDeduction + 
							pensionFundDeduction + 
							sharesInsuranceDeduction + 
							houseLoanInterestDeduction;
		
		Double actualTax = Math.min(tax, taxSaving);
		
		Double taxSavingPercent = actualTax/tax * 100;;
		
		Double plannedTax = tax - actualTax;
		
		result.setTotalTaxSaving(taxSaving);
		result.setTaxSavingPercent(taxSavingPercent);
		result.setActualTaxPayable(actualTax);
		result.setPlannedTaxYearly(plannedTax);
		result.setPlannedTaxMonthly( toMonthly(plannedTax) );
		
	} 
	
	private void setInputs(Double income, Double increase, Double zakat, InputType inputType, TaxResult result) {
		
		// ============================== Congfiguring inputs monthly and yearly  ====================================		
		// Input Type Only Decides income and increase values to be monthly and yearly   
		if (inputType == InputType.MONTHLY) {
			result.setUiIncomeYearly( toYearly(income) ); 
			result.setUiIncomeMonthly(income);
			
			result.setUiExpectedIncreaseYearly(toYearly(increase));
			result.setUiExpectedIncreaseMonthly(increase);
			
			result.setTaxableIncomeYearly( toYearly(income-zakat) );
			result.setTaxableIncomeMonthly(income-zakat);
			
			result.setExpectedTaxableIncomeMonthly(income+increase);
			result.setExpectedTaxableIncomeYearly( toYearly(income+increase) );
			
		} else if (inputType == InputType.YEARLY) {
			result.setUiIncomeYearly(income);
			result.setUiIncomeMonthly( toMonthly(income) );
			
			result.setUiExpectedIncreaseYearly(increase);
			result.setUiExpectedIncreaseMonthly( toMonthly(increase) );
			
			result.setTaxableIncomeYearly(income-zakat);
			result.setTaxableIncomeMonthly( toMonthly(income-zakat) );
			
			result.setExpectedTaxableIncomeYearly(income+increase);
			result.setExpectedTaxableIncomeMonthly( toMonthly(income+increase) );
		}
	}

//	===================== Abstract methods implemenations which are called from manager ==================
	
	@Override
	TaxResult calculateTax(Double income, InputType inputType) {
		
		TaxResult result = new TaxResult();
		
		setInputs(income, 0d, 0d, inputType, result);
		
		calcTax(result);
		
		return result;
	}

	@Override
	TaxResult calculateImpactOfIncrement(Double income, Double increase, InputType inputType) {
		
		TaxResult result = new TaxResult();
		
		setInputs(income, increase, 0d, inputType, result);
		
		calcTax(result);
		calcImpactOfIncrement(result);
		
		return result;
	}
	
	@Override
	TaxResult calculateTaxPlanning(Double income, Double zakat,
			Double donation, Double shares, Double insurancePremium,
			Double pensionFund, int age, Double houseLoanInterest,
			InputType inputType) {
		
		TaxResult result = new TaxResult();
		
		setInputs(income, 0d, zakat, inputType, result);
			
		result.setUiZakat(zakat);
		result.setUiDonation(donation);
		result.setUiShares(shares);
		result.setUiInsurance(insurancePremium);
		result.setUiAge(age);
		result.setUiHouseLoanInterest(houseLoanInterest);
		
		calcTax(result);
		calcPlanning(result);
		calcAnalysis(result);

		return result;
	}
}
