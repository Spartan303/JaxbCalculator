package com.netpace.jtc.api;

public class TaxResult {

	private double uiMonthlyIncome;
	private double uiYearlyIncome;
	private double uiMonthlyExpectedIncrease;
	private double uiYearlyExpectedIncrease;

	private double uiZakat;
	private double uiDonation;
	private double uiShares;
	private double uiInsurance;
	private double uiPension;
	private int uiAge;
	private double uiHouseLoanInterest;

	private double cSlabStart;
	private double cSlabEnd;
	private double cSlabFixTax;
	private double cSlabVarTax;

	private double yExpectedIncome;
	private double mExpectedIncome;

	private double yTaxableIncome;
	private double mTaxableIncome;
	private double yExpectedTaxableIncome;
	private double mExpectedTaxableIncome;

	private double yIncreaseInTaxableIncome;
	private double mIncreaseInTaxableIncome;

	private double yTax;
	private double mTax;
	private double yExpectedTax;
	private double mExpectedTax;

	private double yIncreaseInTax;
	private double mIncreaseInTax;

	private double yTakeHomeIncome;
	private double mTakeHomeIncome;
	private double yExpectedTakeHomeIncome;
	private double mExpectedTakeHomeIncome;

	private double yIncreaseInTakeHomeIncome;
	private double mIncreaseInTakeHomeIncome;

	private double avgRateOfTax;
	private double expAvgRateOfTax;

	private double zakatDeduction;
	private double donationDeduction;
	private double shares_InsuranceDeduction;
	private double pensionDeduction;
	private double houseLoanInterestDeduction;
	private double totalTaxSaving;

	private double actualTaxPayable;

	private double taxSavingPercent;

	private double yPlannedTax;
	private double mPlannedTax;
	private double yExpectedPlannedTax;
	private double mExpectedPlannedTax;
	
	// UI values
	public double getUiIncomeMonthly() {
		return uiMonthlyIncome;
	}
	public void setUiIncomeMonthly(double uiMonthlyIncome) {
		this.uiMonthlyIncome = uiMonthlyIncome;
	}
	public double getUiIncomeYearly() {
		return uiYearlyIncome;
	}
	public void setUiIncomeYearly(double uiYearlyIncome) {
		this.uiYearlyIncome = uiYearlyIncome;
	}
	public double getUiMonthlyExpectedIncrease() {
		return uiMonthlyExpectedIncrease;
	}
	public void setUiMonthlyExpectedIncrease(double uiMonthlyExpectedIncrease) {
		this.uiMonthlyExpectedIncrease = uiMonthlyExpectedIncrease;
	}
	public double getUiYearlyMonthlyExpectedIncrease() {
		return uiYearlyExpectedIncrease;
	}
	public void setUiYearlyExpectedIncrease(double uiYearlyExpectedIncrease) {
		this.uiYearlyExpectedIncrease = uiYearlyExpectedIncrease;
	}
	public double getUiZakat() {
		return uiZakat;
	}
	public void setUiZakat(double uiZakat) {
		this.uiZakat = uiZakat;
	}
	public double getUiDonation() {
		return uiDonation;
	}
	public void setUiDonation(double uiDonation) {
		this.uiDonation = uiDonation;
	}
	public double getUiShares() {
		return uiShares;
	}
	public void setUiShares(double uiShares) {
		this.uiShares = uiShares;
	}
	public double getUiInsurance() {
		return uiInsurance;
	}
	public void setUiInsurance(double uiInsurance) {
		this.uiInsurance = uiInsurance;
	}
	public double getUiPension() {
		return uiPension;
	}
	public void setUiPension(double uiPension) {
		this.uiPension = uiPension;
	}
	public int getUiAge() {
		return uiAge;
	}
	public void setUiAge(int uiAge) {
		this.uiAge = uiAge;
	}
	public double getUiHouseLoanInterest() {
		return uiHouseLoanInterest;
	}
	public void setUiHouseLoanInterest(double uiHouseLoanInterest) {
		this.uiHouseLoanInterest = uiHouseLoanInterest;
	}
	
	// slab values
	public double getcSlabStart() {
		return cSlabStart;
	}
	public void setcSlabStart(double cSlabStart) {
		this.cSlabStart = cSlabStart;
	}
	public double getcSlabEnd() {
		return cSlabEnd;
	}
	public void setcSlabEnd(double cSlabEnd) {
		this.cSlabEnd = cSlabEnd;
	}
	public double getcSlabFixTax() {
		return cSlabFixTax;
	}
	public void setcSlabFixTax(double cSlabFixTax) {
		this.cSlabFixTax = cSlabFixTax;
	}
	public double getcSlabVarTax() {
		return cSlabVarTax;
	}
	public void setcSlabVarTax(double cSlabVarTax) {
		this.cSlabVarTax = cSlabVarTax;
	}
	
	
	// result values
	
	public double getExpectedIncomeYearly() {
		return yExpectedIncome;
	}
	public void setExpectedIncomeYearly(double yExpectedIncome) {
		this.yExpectedIncome = yExpectedIncome;
	}
	public double getExpectedIncomeMonthly() {
		return mExpectedIncome;
	}
	public void setExpectedIncomeMonthly(double mExpectedIncome) {
		this.mExpectedIncome = mExpectedIncome;
	}
	public double getTaxableIncomeYearly() {
		return yTaxableIncome;
	}
	public void setTaxableIncomeYearly(double yTaxableIncome) {
		this.yTaxableIncome = yTaxableIncome;
	}
	public double getTaxableIncomeMonthly() {
		return mTaxableIncome;
	}
	public void setTaxableIncomeMonthly(double mTaxableIncome) {
		this.mTaxableIncome = mTaxableIncome;
	}
	public double getExpectedTaxableIncomeYearly() {
		return yExpectedTaxableIncome;
	}
	public void setExpectedTaxableIncomeYearly(double yExpectedTaxableIncome) {
		this.yExpectedTaxableIncome = yExpectedTaxableIncome;
	}
	public double getExpectedTaxableIncomeMonthly() {
		return mExpectedTaxableIncome;
	}
	public void setExpectedTaxableIncomeMonthly(double mExpectedTaxableIncome) {
		this.mExpectedTaxableIncome = mExpectedTaxableIncome;
	}
	public double getIncreaseInTaxableIncomeYearly() {
		return yIncreaseInTaxableIncome;
	}
	public void setIncreaseInTaxableIncomeYearly(
			double yIncreaseInTaxableIncome) {
		this.yIncreaseInTaxableIncome = yIncreaseInTaxableIncome;
	}
	public double getIncreaseInTaxableIncomeMonthly() {
		return mIncreaseInTaxableIncome;
	}
	public void setIncreaseInTaxableIncomeMonthly(
			double mIncreaseInTaxableIncome) {
		this.mIncreaseInTaxableIncome = mIncreaseInTaxableIncome;
	}
	public double getTaxYearly() {
		return yTax;
	}
	public void setTaxYearly(double yTax) {
		this.yTax = yTax;
	}
	public double getTaxMonthly() {
		return mTax;
	}
	public void setTaxMonthly(double mTax) {
		this.mTax = mTax;
	}
	public double getExpectedTaxYearly() {
		return yExpectedTax;
	}
	public void setExpectedTaxYearly(double yExpectedTax) {
		this.yExpectedTax = yExpectedTax;
	}
	public double getExpectedTaxMonthly() {
		return mExpectedTax;
	}
	public void setExpectedTaxMonthly(double mExpectedTax) {
		this.mExpectedTax = mExpectedTax;
	}
	public double getIncreaseInTaxYearly() {
		return yIncreaseInTax;
	}
	public void setIncreaseInTaxYearly(double yIncreaseInTax) {
		this.yIncreaseInTax = yIncreaseInTax;
	}
	public double getIncreaseInTaxMonthly() {
		return mIncreaseInTax;
	}
	public void setIncreaseInTaxMonthly(double mIncreaseInTax) {
		this.mIncreaseInTax = mIncreaseInTax;
	}
	public double getTakeHomeIncomeYearly() {
		return yTakeHomeIncome;
	}
	public void setTakeHomeIncomeYearly(double yTakeHomeIncome) {
		this.yTakeHomeIncome = yTakeHomeIncome;
	}
	public double getTakeHomeIncomeMonthly() {
		return mTakeHomeIncome;
	}
	public void setTakeHomeIncomeMonthly(double mTakeHomeIncome) {
		this.mTakeHomeIncome = mTakeHomeIncome;
	}
	public double getExpectedTakeHomeIncomeYearly() {
		return yExpectedTakeHomeIncome;
	}
	public void setExpectedTakeHomeIncomeYearly(double yExpectedTakeHomeIncome) {
		this.yExpectedTakeHomeIncome = yExpectedTakeHomeIncome;
	}
	public double getExpectedTakeHomeIncomeMonthly() {
		return mExpectedTakeHomeIncome;
	}
	public void setExpectedTakeHomeIncomeMonthly(double mExpectedTakeHomeIncome) {
		this.mExpectedTakeHomeIncome = mExpectedTakeHomeIncome;
	}
	public double getIncreaseInTakeHomeIncomeYearly() {
		return yIncreaseInTakeHomeIncome;
	}
	public void setIncreaseInTakeHomeIncomeYearly(
			double yIncreaseInTakeHomeIncome) {
		this.yIncreaseInTakeHomeIncome = yIncreaseInTakeHomeIncome;
	}
	public double getIncreaseInTakeHomeIncomeMonthly() {
		return mIncreaseInTakeHomeIncome;
	}
	public void setIncreaseInTakeHomeIncomeMonthly(
			double mIncreaseInTakeHomeIncome) {
		this.mIncreaseInTakeHomeIncome = mIncreaseInTakeHomeIncome;
	}
	public double getAvgRateOfTax() {
		return avgRateOfTax;
	}
	public void setAvgRateOfTax(double avgRateOfTax) {
		this.avgRateOfTax = avgRateOfTax;
	}
	public double getExpAvgRateOfTax() {
		return expAvgRateOfTax;
	}
	public void setExpAvgRateOfTax(double expAvgRateOfTax) {
		this.expAvgRateOfTax = expAvgRateOfTax;
	}
	public double getZakatDeduction() {
		return zakatDeduction;
	}
	public void setZakatDeduction(double zakatDeduction) {
		this.zakatDeduction = zakatDeduction;
	}
	public double getDonationDeduction() {
		return donationDeduction;
	}
	public void setDonationDeduction(double donationDeduction) {
		this.donationDeduction = donationDeduction;
	}
	public double getShares_InsuranceDeduction() {
		return shares_InsuranceDeduction;
	}
	public void setShares_InsuranceDeduction(double shares_InsuranceDeduction) {
		this.shares_InsuranceDeduction = shares_InsuranceDeduction;
	}
	public double getPensionDeduction() {
		return pensionDeduction;
	}
	public void setPensionDeduction(double pensionDeduction) {
		this.pensionDeduction = pensionDeduction;
	}
	public double getHouseLoanInterestDeduction() {
		return houseLoanInterestDeduction;
	}
	public void setHouseLoanInterestDeduction(double houseLoanInterestDeduction) {
		this.houseLoanInterestDeduction = houseLoanInterestDeduction;
	}
	public double getTotalTaxSaving() {
		return totalTaxSaving;
	}
	public void setTotalTaxSaving(double totalTaxSaving) {
		this.totalTaxSaving = totalTaxSaving;
	}
	public double getActualTaxPayable() {
		return actualTaxPayable;
	}
	public void setActualTaxPayable(double actualTaxPayable) {
		this.actualTaxPayable = actualTaxPayable;
	}
	public double getTaxSavingPercent() {
		return taxSavingPercent;
	}
	public void setTaxSavingPercent(double taxSavingPercent) {
		this.taxSavingPercent = taxSavingPercent;
	}
	public double getPlannedTaxYearly() {
		return yPlannedTax;
	}
	public void setPlannedTaxYearly(double yPlannedTax) {
		this.yPlannedTax = yPlannedTax;
	}
	public double getPlannedTaxMonthly() {
		return mPlannedTax;
	}
	public void setPlannedTaxMonthly(double mPlannedTax) {
		this.mPlannedTax = mPlannedTax;
	}
	public double getExpectedPlannedTaxYearly() {
		return yExpectedPlannedTax;
	}
	public void setExpectedPlannedTaxYearly(double yExpectedPlannedTax) {
		this.yExpectedPlannedTax = yExpectedPlannedTax;
	}
	public double getExpectedPlannedTaxMonthly() {
		return mExpectedPlannedTax;
	}
	public void setExpectedPlannedTaxMonthly(double mExpectedPlannedTax) {
		this.mExpectedPlannedTax = mExpectedPlannedTax;
	}
}

