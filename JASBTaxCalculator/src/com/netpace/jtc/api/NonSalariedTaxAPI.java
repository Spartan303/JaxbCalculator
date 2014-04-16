package com.netpace.jtc.api;

import java.util.Calendar;

public class NonSalariedTaxAPI extends TaxAPI {
	
	private static TaxSlabSheet slabSheet;
	static String fileName_prefix = "Slabs_NS_";
	static Integer year = Calendar.getInstance().get(Calendar.YEAR);

// ==================== Constructor ===========================
	
	public NonSalariedTaxAPI(int year) {
		if (slabSheet == null ||  SalariedTaxAPI.year != year)
			NonSalariedTaxAPI.slabSheet = getSlabSheet(year);
		NonSalariedTaxAPI.year = year;
	}
	
// ====================  Helper method to load sheet first time or when year is changed  ===========================
	
	private TaxSlabSheet getSlabSheet(int year) {
		
		String sFileName = NonSalariedTaxAPI.fileName_prefix + SalariedTaxAPI.year.toString() + ".csv";
		  
		return TaxSlabSheet.load(sFileName, year);
	}

	@Override
	TaxResult calculateTaxPlanning(Double income, Double zakat,
			Double donation, Double shares, Double insurancePremium,
			Double pensionFund, int age, Double houseLoanInterest,
			InputType inputType) {
		
		TaxResult taxResult = new TaxResult();
		
		if (inputType == InputType.MONTHLY) {
			taxResult.setUiIncomeMonthly(income);
			taxResult.setUiIncomeYearly( toYearly(income) );
		}
		else if (inputType == InputType.YEARLY) {
			taxResult.setUiIncomeMonthly( toMonthly(income) );
			taxResult.setUiIncomeYearly(income);
		}
		
		taxResult.setUiZakat(zakat);
		taxResult.setUiDonation(donation);
		taxResult.setUiShares(shares);
		taxResult.setUiInsurance(insurancePremium);
		taxResult.setUiPension(pensionFund);
		taxResult.setUiAge(age);
		taxResult.setUiHouseLoanInterest(houseLoanInterest);
		
/*		taxResult.setcSlabStart(0);
		taxResult.setcSlabEnd(0);
		taxResult.setcSlabFixTax(0);
		taxResult.setcSlabVarTax(0);*/
		
		taxResult.setTaxableIncomeYearly( taxResult.getUiIncomeYearly() - zakat );
		taxResult.setTaxableIncomeMonthly( (double) Math.round(taxResult.getTaxableIncomeYearly() / 12) );
		
		calcTax(taxResult);
		
		taxResult.setTakeHomeIncomeYearly( taxResult.getTaxableIncomeYearly() - taxResult.getTaxYearly() );
		taxResult.setTakeHomeIncomeMonthly(	taxResult.getTaxableIncomeMonthly() - taxResult.getTaxMonthly() );
		
		taxResult.setAvgRateOfTax( (double) Math.round( taxResult.getTaxYearly()/taxResult.getTaxableIncomeYearly()) );
		
		//calcZakatDeduction(taxResult);
		calcDonationDeduction(taxResult);
		calcSharesInsuranceDeduction(taxResult);
		calcPensionFundDeduction(taxResult);
		calcHouseLoanInterestDeduction(taxResult);
		
		taxResult.setTotalTaxSaving(
				taxResult.getZakatDeduction() +
				taxResult.getDonationDeduction() + 
				taxResult.getShares_InsuranceDeduction() +
				taxResult.getPensionDeduction() + 
				taxResult.getHouseLoanInterestDeduction()
				);
		
		taxResult.setActualTaxPayable( Math.min(taxResult.getTaxYearly(), taxResult.getTotalTaxSaving()) );
		
		taxResult.setTaxSavingPercent( taxResult.getActualTaxPayable() / taxResult.getTaxYearly() );
		
		taxResult.setPlannedTaxYearly( taxResult.getTaxYearly() - taxResult.getActualTaxPayable() );
		taxResult.setPlannedTaxMonthly( toMonthly(taxResult.getPlannedTaxYearly()) );
		
		return taxResult;
	}

	@Override
	TaxResult calculateTax(Double income, InputType inputType) {
		
		TaxResult taxResult = new TaxResult();
		
		if (inputType == InputType.MONTHLY) {
			taxResult.setUiIncomeMonthly(income);
			taxResult.setUiIncomeYearly( toYearly(income) );
		}
		else if (inputType == InputType.YEARLY) {
			taxResult.setUiIncomeMonthly( toMonthly(income) );
			taxResult.setUiIncomeYearly(income);
		}
		
/*		taxResult.setcSlabStart(0);
		taxResult.setcSlabEnd(0);
		taxResult.setcSlabFixTax(0);
		taxResult.setcSlabVarTax(0);
		*/
		taxResult.setTaxableIncomeYearly( taxResult.getUiIncomeYearly() );
		taxResult.setTaxableIncomeMonthly( (double) Math.round(taxResult.getTaxableIncomeYearly() / 12) );
		
		calcTax(taxResult);
		
		taxResult.setTakeHomeIncomeYearly( taxResult.getTaxableIncomeYearly() - taxResult.getTaxYearly() );
		taxResult.setTakeHomeIncomeMonthly(	taxResult.getTaxableIncomeMonthly() - taxResult.getTaxMonthly() );
		
		taxResult.setAvgRateOfTax( (double) Math.round( taxResult.getTaxYearly()/taxResult.getTaxableIncomeYearly()) );
		
		return taxResult;
	}

	@Override
	TaxResult calculateImpactOfIncrement(Double income, Double increase,
			InputType inputType) {
		
		TaxResult taxResult = new TaxResult();
		
		if (inputType == InputType.MONTHLY) {
			taxResult.setUiIncomeMonthly(income);
			taxResult.setUiIncomeYearly( toYearly(income) );
			
			taxResult.setExpectedIncomeMonthly( income + increase );
			taxResult.setExpectedIncomeYearly( toYearly(income + increase) );
		}
		else if (inputType == InputType.YEARLY) {
			taxResult.setUiIncomeMonthly( toMonthly(income) );
			taxResult.setUiIncomeYearly(income);
			
			taxResult.setExpectedIncomeMonthly( toMonthly(income + increase) );
			taxResult.setExpectedIncomeYearly( income + increase );
		}
		
/*		taxResult.setcSlabStart(0);
		taxResult.setcSlabEnd(0);
		taxResult.setcSlabFixTax(0);
		taxResult.setcSlabVarTax(0);*/
		
		taxResult.setTaxableIncomeYearly( taxResult.getUiIncomeYearly() );
		taxResult.setTaxableIncomeMonthly( (double) Math.round(taxResult.getTaxableIncomeYearly() / 12) );
		taxResult.setExpectedTaxableIncomeYearly( taxResult.getExpectedIncomeYearly() );
		taxResult.setExpectedTaxableIncomeMonthly( (double) Math.round(taxResult.getExpectedTaxableIncomeYearly() / 12) );
		
		taxResult.setIncreaseInTaxableIncomeYearly(	taxResult.getExpectedTaxableIncomeYearly() - taxResult.getTaxableIncomeYearly() );
		taxResult.setIncreaseInTaxableIncomeMonthly( taxResult.getExpectedTaxableIncomeMonthly() - taxResult.getTaxableIncomeMonthly() );
		
		calcTax(taxResult);
		
		taxResult.setIncreaseInTaxYearly( taxResult.getExpectedTaxYearly() - taxResult.getTaxYearly() );
		taxResult.setIncreaseInTaxMonthly( taxResult.getExpectedTaxMonthly() - taxResult.getTaxMonthly() );
		
		taxResult.setTakeHomeIncomeYearly( taxResult.getTaxableIncomeYearly() - taxResult.getTaxYearly() );
		taxResult.setTakeHomeIncomeMonthly(	taxResult.getTaxableIncomeMonthly() - taxResult.getTaxMonthly() );
		taxResult.setExpectedTakeHomeIncomeYearly( taxResult.getExpectedTaxableIncomeYearly() - taxResult.getExpectedTaxYearly() );
		taxResult.setExpectedTakeHomeIncomeMonthly(	taxResult.getExpectedTaxableIncomeMonthly()- taxResult.getExpectedTaxMonthly() );
		
		taxResult.setIncreaseInTakeHomeIncomeYearly( taxResult.getExpectedTakeHomeIncomeYearly() - taxResult.getTakeHomeIncomeYearly() );
		taxResult.setIncreaseInTakeHomeIncomeMonthly( taxResult.getExpectedTakeHomeIncomeMonthly() - taxResult.getTakeHomeIncomeMonthly() );
		
		taxResult.setAvgRateOfTax( (double) Math.round( taxResult.getTaxYearly()/taxResult.getTaxableIncomeYearly()) );
		taxResult.setExpAvgRateOfTax( (double) Math.round( taxResult.getExpectedTaxYearly()/taxResult.getExpectedTaxableIncomeYearly()) );
		
		return taxResult;
	}

	@Override
	void calcTax(TaxResult result) {
		
		Double tax = result.getcSlabFixTax() + 
				( (result.getTaxableIncomeYearly()-result.getcSlabStart()-1) * (result.getcSlabVarTax()/100) );
		
		result.setTaxYearly( tax );
		result.setTaxMonthly( (double) Math.round(tax/12) );
		
		Double expectedTax = result.getcSlabFixTax() + 
				( (result.getExpectedTaxableIncomeYearly()-result.getcSlabStart()-1) * (result.getcSlabVarTax()/100) );
		
		result.setExpectedTaxYearly( expectedTax );
		result.setExpectedTaxMonthly( (double) Math.round(result.getExpectedTaxYearly()/12) );
	}

	@Override
	void calcZakatDeduction(TaxResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void calcDonationDeduction(TaxResult result) {
		
		Double donationDeduction = Math.min(result.getUiDonation(), (result.getTaxableIncomeYearly()*(30/100)))
									* (result.getAvgRateOfTax()/100);
		
		result.setDonationDeduction(donationDeduction);
	}

	@Override
	void calcSharesInsuranceDeduction(TaxResult result) {
		
		Double shares_InsuranceDeduction = Math.min((result.getUiShares() + result.getUiInsurance()), 1000000) 
											* (result.getAvgRateOfTax()/100);
		result.setShares_InsuranceDeduction(shares_InsuranceDeduction);
	}

	@Override
	void calcPensionFundDeduction(TaxResult result) {
		
		Double limit2 = 0d;
		int age = result.getUiAge();
		Double taxableIncome = result.getTaxableIncomeYearly();
		if (age <= 40) {
			limit2 = taxableIncome*(20/100);
		}
		if (age > 40 && age<=55) {
			limit2 = taxableIncome*((20+(age-40)*2)/100);
		}
		if (age > 55) {
			limit2 = taxableIncome*((20+(55-40)*2)/100);
		}
		Double pensionFundDeduction = Math.min(result.getUiPension(), limit2)
										*(result.getAvgRateOfTax()/100);
		
		result.setPensionDeduction(pensionFundDeduction);
	}

	@Override
	void calcHouseLoanInterestDeduction(TaxResult result) {
		
		Double houseLoanInterestDeduction = Math.min(result.getUiHouseLoanInterest(), result.getTaxableIncomeYearly()*(50/100)) 
											* (result.getAvgRateOfTax()/100);
		
		result.setHouseLoanInterestDeduction(houseLoanInterestDeduction);
	}
}
