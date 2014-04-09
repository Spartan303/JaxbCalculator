package com.netpace.jtc.api;

public class NonSalariedTaxAPI extends TaxAPI {

	@Override
	TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, double donation, double shares,
			double insurancePremium, double pensionFund, int age,
			double houseLoanInterest, InputType inputType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TaxResult getTaxCalculationResult(double income, double increase,
			double zakat, InputType inputType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	double getZakatDeduction(double zakat, double taxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getDonationDeduction(double donation, double taxableIncome,
			double avgRateofTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getSharesInsuranceDeduction(double shares, double insurancePremium,
			double taxableIncome, double avgRateofTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getPensionFundDeduction(double pensionFund, int age,
			double taxableIncome, double avgRateofTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getHouseLoanInterestDeduction(double houseLoanInterest,
			double taxableIncome, double avgRateofTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getTax(double taxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

}
