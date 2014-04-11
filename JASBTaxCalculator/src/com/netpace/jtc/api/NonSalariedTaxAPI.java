package com.netpace.jtc.api;

public class NonSalariedTaxAPI extends TaxAPI {

	@Override
	TaxResult calculateTaxPlanning(Double income, Double zakat,
			Double donation, Double shares, Double insurancePremium,
			Double pensionFund, int age, Double houseLoanInterest,
			InputType inputType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TaxResult calculateTax(Double income, InputType inputType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TaxResult calculateImpactOfIncrement(Double income, Double increase,
			InputType inputType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void calcTax(TaxResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void calcZakatDeduction(TaxResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void calcDonationDeduction(TaxResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void calcSharesInsuranceDeduction(TaxResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void calcPensionFundDeduction(TaxResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void calcHouseLoanInterestDeduction(TaxResult result) {
		// TODO Auto-generated method stub
		
	}
}
