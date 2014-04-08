package com.netpace.jtc.api;

public class NonSalariedTaxAPI implements TaxAPI {

	@Override
	public double getTaxableIncome(double income, double zakat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedIncome(double income, double increase) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedTaxableIncome(double income, double increase,
			double zakat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTaxableIncome(double oldTaxableIncome,
			double newTaxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTax(double taxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTax(double oldTax, double newTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTakeHomeIncome(double taxableIncome, double tax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTakeHomeIncome(double oldTakeHomeIncome,
			double newTakeHomeIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAvgRateOfTax(double tax, double taxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxSaving(double zakatDeduction, double donationDeduction,
			double sharesInsuranceDeduction, double pensionFundDeduction,
			double houseLoanInterestDeduction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getActualTax(double tax, double taxSaving) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxSavingPercent(double actualTax, double tax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPlannedTax(double tax, double taxSaving) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getZakatDeduction(double zakat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDonationDeduction(double donation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSharesInsuranceDeduction(double shares,
			double insurancePremium) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPensionFundDeduction(double pensionFund, int age) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHouseLoanInterestDeduction(double houseLoanInterest) {
		// TODO Auto-generated method stub
		return 0;
	}

}
