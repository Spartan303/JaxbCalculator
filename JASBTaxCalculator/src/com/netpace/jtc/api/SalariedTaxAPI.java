package com.netpace.jtc.api;

import android.graphics.YuvImage;

public class SalariedTaxAPI extends TaxAPI {

	@Override
	void calcTax(TaxResult result) {
		
		double taxableIncome = result.getTaxableIncomeYearly();		
		double tax = getTax(taxableIncome);
		double yTakeHomeIncome = taxableIncome - tax;
		
		result.setTaxYearly(tax);
		result.setTaxMonthly(toMonthly(tax));
		
		result.setTakeHomeIncomeYearly(yTakeHomeIncome);
		result.setTakeHomeIncomeMonthly( toMonthly(yTakeHomeIncome) );
	}
	
	private void calcImpactOfIncrement(TaxResult result) {

		double newTaxableIncome = result.getExpectedTaxableIncomeYearly();
		
		double newTax = getTax(newTaxableIncome);
		double oldTax = result.getTaxYearly();
		double yIncreaseInTax = newTax - oldTax;
		
		double newTakeHomeIncome = newTaxableIncome - newTax;
		double oldTakeHomeIncome = result.getTakeHomeIncomeYearly();
		double yIncreaseInTakeHomeIncome = newTakeHomeIncome - oldTakeHomeIncome;
		
		result.setExpectedTaxYearly(newTax);
		result.setTaxMonthly( toMonthly(newTax) );
		
		result.setIncreaseInTaxYearly(yIncreaseInTax);
		result.setIncreaseInTaxMonthly( toMonthly(yIncreaseInTax) );
		
		result.setExpectedTakeHomeIncomeYearly(newTakeHomeIncome);
		result.setExpectedTakeHomeIncomeMonthly( toMonthly(newTakeHomeIncome) );
		
		result.setIncreaseInTakeHomeIncomeYearly(yIncreaseInTakeHomeIncome);
		result.setIncreaseInTakeHomeIncomeYearly( toMonthly(yIncreaseInTakeHomeIncome) );
	}
	
	
	private double getTax(double amount) {
		// Slab slab = findSlab(taxableIncome);	// actual line 
		Slab slab = new Slab(400001d, 75000d, 0d, 5f); // just for testing
		
		double offset = slab.getOffsetValue();
		double percent = slab.getPercentValue();
		double exceedAmount = amount - slab.getStartValue();
		double tax = offset + exceedAmount * percent;
		
		return tax;
	}

	@Override
	void calcZakatDeduction(TaxResult result) {
		
		double zakat = result.getZakatDeduction();
		double taxableIncome = result.getTaxableIncomeYearly();
		
		result.setZakatDeduction(Math.min(zakat, taxableIncome));
	}

	@Override
	void calcDonationDeduction(TaxResult result) {
		
		// Limit 1: Amount of donation = a
		// Limit 2: 30% of taxable income = b
		// Formula: MIN(a, b) * avgRateofTax
		
		double avgRateofTax = result.getAvgRateOfTax();
		double donation = result.getUiDonation();
		double taxableIncome = result.getTaxableIncomeYearly();
		double taxableIncomePart = 0.3 * taxableIncome;
		
		result.setDonationDeduction(Math.min(donation, taxableIncomePart) * avgRateofTax);
		
	}

	@Override
	void calcSharesInsuranceDeduction(TaxResult result) {

		double shares = result.getUiShares();
		double insurancePremium = result.getUiInsurance();
		double taxableIncome = result.getTaxableIncomeYearly();
		double avgRateofTax = result.getAvgRateOfTax();
		
		// Limit 1: Amount of Shares + Insurance = a
		// Limit 2: 20% of taxable income = b
		// Limit 3: 1 Million per year = c
		// Formula: MIN(a, b, c) * avgRateofTax

		double amountOfSharesAndInsurance = shares + insurancePremium;
		double taxableIncomePart = taxableIncome * 0.2;
		double CONSTANT_LIMIT = 1000000; // 1 million

		double shares_InsuranceDeduction = Math.min(amountOfSharesAndInsurance, Math.min(taxableIncomePart, CONSTANT_LIMIT)) * avgRateofTax;
		
		result.setShares_InsuranceDeduction(shares_InsuranceDeduction); 
	}

	@Override
	void calcPensionFundDeduction(TaxResult result) {

		
		double pensionFund = result.getUiPension(); 
		int age = result.getUiAge();
		double taxableIncome = result.getTaxableIncomeYearly(); 
		double avgRateofTax = result.getAvgRateOfTax(); 
		
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

		result.setPensionDeduction(Math.min(pensionFund, taxableIncomePart) * avgRateofTax);
	}

	@Override
	void calcHouseLoanInterestDeduction(TaxResult result) {
		
		double houseLoanInterest = result.getUiHouseLoanInterest();
		double taxableIncome = result.getTaxableIncomeYearly(); 
		double avgRateofTax = result.getAvgRateOfTax();

		// Limit 1: Amount of Interest on House Loan = a
		// Limit 2: 50% of taxable income = b
		// Limit 3: 75,000 per year
		// Formula: MIN(a, b, c) * avgRateofTax

		double taxableIncomePart = taxableIncome * 0.5;
		double CONSTANT_LIMIT = 1000000; // 1 million
		
		double houseLoanInterestDeduction = Math.min(houseLoanInterest,
				Math.min(taxableIncomePart, CONSTANT_LIMIT))
				* avgRateofTax;

		result.setHouseLoanInterestDeduction(houseLoanInterestDeduction);
	}
	
	
	
	@Override
	TaxResult calculateTaxResult(double income, double increase, double zakat,
			double donation, double shares, double insurancePremium,
			double pensionFund, int age, double houseLoanInterest,
			InputType inputType) {
		
		TaxResult result = new TaxResult();
		
// ============================== Congfiguring inputs monthly and yearly  ====================================		

			// Input Type Only Decides income and increase values to be monthly and yearly   
			if (inputType == InputType.MONTHLY) {
				result.setUiIncomeYearly( toYearly(income) ); // 60,000
				result.setUiIncomeMonthly(income); // 50,000
				
				result.setUiExpectedIncreaseYearly(toYearly(increase)); // 0
				result.setUiExpectedIncreaseMonthly(increase); // 0
				
			} else {
				result.setUiIncomeYearly(income); // 60,000
				result.setUiIncomeMonthly( toMonthly(income) ); // 50,000
				
				result.setUiExpectedIncreaseYearly(toYearly(increase)); // 0
				result.setUiExpectedIncreaseMonthly( toMonthly(increase) ); // 0			
			}
			
			result.setUiZakat(zakat);
			result.setUiDonation(donation);
			result.setUiShares(shares);
			result.setUiInsurance(insurancePremium);
			result.setUiAge(age);
			result.setUiHouseLoanInterest(houseLoanInterest);
			
//  ===========================================================================================================
		
		// Set the taxable Income
		double yTaxableIncome = result.getUiIncomeYearly() - result.getUiZakat();
		double mTaxableIncome = toMonthly(yTaxableIncome);
		result.setTaxableIncomeYearly(yTaxableIncome);
		
		result.setTaxableIncomeMonthly(mTaxableIncome);
		
		calcTax(result);
		

		
		
		return null;
	}
	
	
	
	
	
	
	
	
}
