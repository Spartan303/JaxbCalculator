package com.netpace.jtc.api;

public class SalariedTaxAPI implements TaxAPI {

	@Override
	public double getTaxableIncomeMonthly(double income, double zakat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxableIncomeYearly(double income, double zakat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedIncomeMonthly(double income, double increase) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedIncomeYearly(double income, double increase) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedTaxableIncomeMonthly(double income,
			double increase, double zakat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedTaxableIncomeYearly(double income,
			double increase, double zakat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTaxableIncomeMonthly(double oldTaxableIncome,
			double newTaxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTaxableIncomeYearly(double oldTaxableIncome,
			double newTaxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxMonthly(double taxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxYearly(double taxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedTaxMonthly(double newTaxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedTaxYearly(double newTaxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTaxMonthly(double oldTax, double newTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTaxYearly(double oldTax, double newTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTakeHomeIncomeMonthly(double taxableIncome, double tax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTakeHomeIncomeYearly(double taxableIncome, double tax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedTakeHomeIncomeMonthly(double newTaxableIncome,
			double newTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedTakeHomeIncomeYearly(double newTaxableIncome,
			double newTax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTakeHomeIncomeMonthly(double oldTakeHomeIncome,
			double newTakeHomeIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIncreaseInTakeHomeIncomeYearly(double oldTakeHomeIncome,
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
	public double getExpectedAvgRateOfTax(double newTax, double newTaxableIncome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxSavingMonthly(double zakatDeduction,
			double donationDeduction, double sharesInsuranceDeduction, 
			double pensionFundDeduction, double houseLoanInterestDeduction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxSavingYearly(double zakatDeduction,
			double donationDeduction, double sharesInsuranceDeduction, 
			double pensionFundDeduction, double houseLoanInterestDeduction) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public double getActualTaxMonthly(double tax, double taxSaving) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getActualTaxYearly(double tax, double taxSaving) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxSavingPercentMonthly(double actualTax, double tax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxSavingPercentYearly(double actualTax, double tax) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPlannedTaxMonthly(double tax, double taxSaving) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPlannedTaxYearly(double tax, double taxSaving) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedPlannedTaxMonthly(double newTax, double taxSaving) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExpectedPlannedTaxYearly(double newTax, double taxSaving) {
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
