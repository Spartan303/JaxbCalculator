package com.netpace.jtc.api;

public class NonSalariedTaxAPI extends TaxAPI {

	@Override
	TaxResult calculateTaxResult(double income, double increase, double zakat,
			double donation, double shares, double insurancePremium,
			double pensionFund, int age, double houseLoanInterest,
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
