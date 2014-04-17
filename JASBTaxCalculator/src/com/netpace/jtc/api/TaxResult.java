package com.netpace.jtc.api;

public class TaxResult {

	private Double uiMonthlyIncome;
	private Double uiYearlyIncome;
	private Double uiMonthlyExpectedIncrease;
	private Double uiYearlyExpectedIncrease;

	private Double uiZakat;
	private Double uiDonation;
	private Double uiShares;
	private Double uiInsurance;
	private Double uiPension;
	private int uiAge;
	private Double uiHouseLoanInterest;

	private Double cSlabStart;
	private Double cSlabEnd;
	private Double cSlabFixTax;
	private Float cSlabVarTax;

	private Double yExpectedIncome;
	private Double mExpectedIncome;

	private Double yTaxableIncome;
	private Double mTaxableIncome;
	private Double yExpectedTaxableIncome;
	private Double mExpectedTaxableIncome;

	private Double yIncreaseInTaxableIncome;
	private Double mIncreaseInTaxableIncome;

	private Double yTax;
	private Double mTax;
	private Double yExpectedTax;
	private Double mExpectedTax;

	private Double yIncreaseInTax;
	private Double mIncreaseInTax;

	private Double yTakeHomeIncome;
	private Double mTakeHomeIncome;
	private Double yExpectedTakeHomeIncome;
	private Double mExpectedTakeHomeIncome;

	private Double yIncreaseInTakeHomeIncome;
	private Double mIncreaseInTakeHomeIncome;

	private Double avgRateOfTax;
	private Double expAvgRateOfTax;

	private Double zakatDeduction;
	private Double donationDeduction;
	private Double shares_InsuranceDeduction;
	private Double pensionDeduction;
	private Double houseLoanInterestDeduction;
	private Double totalTaxSaving;

	private Double actualTaxPayable;

	private Double taxSavingPercent;

	private Double yPlannedTax;
	private Double mPlannedTax;
	private Double yExpectedPlannedTax;
	private Double mExpectedPlannedTax;
	
	// UI values
	public Double getUiIncomeMonthly() {
		return uiMonthlyIncome;
	}
	public void setUiIncomeMonthly(Double uiMonthlyIncome) {
		this.uiMonthlyIncome = uiMonthlyIncome;
	}
	public Double getUiIncomeYearly() {
		return uiYearlyIncome;
	}
	public void setUiIncomeYearly(Double uiYearlyIncome) {
		this.uiYearlyIncome = uiYearlyIncome;
	}
	public Double getUiExpectedIncreaseMonthly() {
		return uiMonthlyExpectedIncrease;
	}
	public void setUiExpectedIncreaseMonthly(Double uiMonthlyExpectedIncrease) {
		this.uiMonthlyExpectedIncrease = uiMonthlyExpectedIncrease;
	}
	public Double getUiExpectedIncreaseYearly() {
		return uiYearlyExpectedIncrease;
	}
	public void setUiExpectedIncreaseYearly(Double uiYearlyExpectedIncrease) {
		this.uiYearlyExpectedIncrease = uiYearlyExpectedIncrease;
	}
	public Double getUiZakat() {
		return uiZakat;
	}
	public void setUiZakat(Double uiZakat) {
		this.uiZakat = uiZakat;
	}
	public Double getUiDonation() {
		return uiDonation;
	}
	public void setUiDonation(Double uiDonation) {
		this.uiDonation = uiDonation;
	}
	public Double getUiShares() {
		return uiShares;
	}
	public void setUiShares(Double uiShares) {
		this.uiShares = uiShares;
	}
	public Double getUiInsurance() {
		return uiInsurance;
	}
	public void setUiInsurance(Double uiInsurance) {
		this.uiInsurance = uiInsurance;
	}
	public Double getUiPension() {
		return uiPension;
	}
	public void setUiPension(Double uiPension) {
		this.uiPension = uiPension;
	}
	public int getUiAge() {
		return uiAge;
	}
	public void setUiAge(int uiAge) {
		this.uiAge = uiAge;
	}
	public Double getUiHouseLoanInterest() {
		return uiHouseLoanInterest;
	}
	public void setUiHouseLoanInterest(Double uiHouseLoanInterest) {
		this.uiHouseLoanInterest = uiHouseLoanInterest;
	}
	
	// slab values
	public Double getcSlabStart() {
		return cSlabStart;
	}
	public void setcSlabStart(Double cSlabStart) {
		this.cSlabStart = cSlabStart;
	}
	public Double getcSlabEnd() {
		return cSlabEnd;
	}
	public void setcSlabEnd(Double cSlabEnd) {
		this.cSlabEnd = cSlabEnd;
	}
	public Double getcSlabFixTax() {
		return cSlabFixTax;
	}
	public void setcSlabFixTax(Double cSlabFixTax) {
		this.cSlabFixTax = cSlabFixTax;
	}
	public Float getcSlabVarTax() {
		return cSlabVarTax;
	}
	public void setcSlabVarTax(Float cSlabVarTax) {
		this.cSlabVarTax = cSlabVarTax;
	}
	
	
	// result values
	
	public Double getExpectedIncomeYearly() {
		return yExpectedIncome;
	}
	public void setExpectedIncomeYearly(Double yExpectedIncome) {
		this.yExpectedIncome = yExpectedIncome;
	}
	public Double getExpectedIncomeMonthly() {
		return mExpectedIncome;
	}
	public void setExpectedIncomeMonthly(Double mExpectedIncome) {
		this.mExpectedIncome = mExpectedIncome;
	}
	public Double getTaxableIncomeYearly() {
		return yTaxableIncome;
	}
	public void setTaxableIncomeYearly(Double yTaxableIncome) {
		this.yTaxableIncome = yTaxableIncome;
	}
	public Double getTaxableIncomeMonthly() {
		return mTaxableIncome;
	}
	public void setTaxableIncomeMonthly(Double mTaxableIncome) {
		this.mTaxableIncome = mTaxableIncome;
	}
	public Double getExpectedTaxableIncomeYearly() {
		return yExpectedTaxableIncome;
	}
	public void setExpectedTaxableIncomeYearly(Double yExpectedTaxableIncome) {
		this.yExpectedTaxableIncome = yExpectedTaxableIncome;
	}
	public Double getExpectedTaxableIncomeMonthly() {
		return mExpectedTaxableIncome;
	}
	public void setExpectedTaxableIncomeMonthly(Double mExpectedTaxableIncome) {
		this.mExpectedTaxableIncome = mExpectedTaxableIncome;
	}
	public Double getIncreaseInTaxableIncomeYearly() {
		return yIncreaseInTaxableIncome;
	}
	public void setIncreaseInTaxableIncomeYearly(
			Double yIncreaseInTaxableIncome) {
		this.yIncreaseInTaxableIncome = yIncreaseInTaxableIncome;
	}
	public Double getIncreaseInTaxableIncomeMonthly() {
		return mIncreaseInTaxableIncome;
	}
	public void setIncreaseInTaxableIncomeMonthly(
			Double mIncreaseInTaxableIncome) {
		this.mIncreaseInTaxableIncome = mIncreaseInTaxableIncome;
	}
	public Double getTaxYearly() {
		return yTax;
	}
	public void setTaxYearly(Double yTax) {
		this.yTax = yTax;
	}
	public Double getTaxMonthly() {
		return mTax;
	}
	public void setTaxMonthly(Double mTax) {
		this.mTax = mTax;
	}
	public Double getExpectedTaxYearly() {
		return yExpectedTax;
	}
	public void setExpectedTaxYearly(Double yExpectedTax) {
		this.yExpectedTax = yExpectedTax;
	}
	public Double getExpectedTaxMonthly() {
		return mExpectedTax;
	}
	public void setExpectedTaxMonthly(Double mExpectedTax) {
		this.mExpectedTax = mExpectedTax;
	}
	public Double getIncreaseInTaxYearly() {
		return yIncreaseInTax;
	}
	public void setIncreaseInTaxYearly(Double yIncreaseInTax) {
		this.yIncreaseInTax = yIncreaseInTax;
	}
	public Double getIncreaseInTaxMonthly() {
		return mIncreaseInTax;
	}
	public void setIncreaseInTaxMonthly(Double mIncreaseInTax) {
		this.mIncreaseInTax = mIncreaseInTax;
	}
	public Double getTakeHomeIncomeYearly() {
		return yTakeHomeIncome;
	}
	public void setTakeHomeIncomeYearly(Double yTakeHomeIncome) {
		this.yTakeHomeIncome = yTakeHomeIncome;
	}
	public Double getTakeHomeIncomeMonthly() {
		return mTakeHomeIncome;
	}
	public void setTakeHomeIncomeMonthly(Double mTakeHomeIncome) {
		this.mTakeHomeIncome = mTakeHomeIncome;
	}
	public Double getExpectedTakeHomeIncomeYearly() {
		return yExpectedTakeHomeIncome;
	}
	public void setExpectedTakeHomeIncomeYearly(Double yExpectedTakeHomeIncome) {
		this.yExpectedTakeHomeIncome = yExpectedTakeHomeIncome;
	}
	public Double getExpectedTakeHomeIncomeMonthly() {
		return mExpectedTakeHomeIncome;
	}
	public void setExpectedTakeHomeIncomeMonthly(Double mExpectedTakeHomeIncome) {
		this.mExpectedTakeHomeIncome = mExpectedTakeHomeIncome;
	}
	public Double getIncreaseInTakeHomeIncomeYearly() {
		return yIncreaseInTakeHomeIncome;
	}
	public void setIncreaseInTakeHomeIncomeYearly(
			Double yIncreaseInTakeHomeIncome) {
		this.yIncreaseInTakeHomeIncome = yIncreaseInTakeHomeIncome;
	}
	public Double getIncreaseInTakeHomeIncomeMonthly() {
		return mIncreaseInTakeHomeIncome;
	}
	public void setIncreaseInTakeHomeIncomeMonthly(
			Double mIncreaseInTakeHomeIncome) {
		this.mIncreaseInTakeHomeIncome = mIncreaseInTakeHomeIncome;
	}
	public Double getAvgRateOfTax() {
		return avgRateOfTax;
	}
	public void setAvgRateOfTax(Double avgRateOfTax) {
		this.avgRateOfTax = avgRateOfTax;
	}
	public Double getExpAvgRateOfTax() {
		return expAvgRateOfTax;
	}
	public void setExpAvgRateOfTax(Double expAvgRateOfTax) {
		this.expAvgRateOfTax = expAvgRateOfTax;
	}
	public Double getZakatDeduction() {
		return zakatDeduction;
	}
	public void setZakatDeduction(Double zakatDeduction) {
		this.zakatDeduction = zakatDeduction;
	}
	public Double getDonationDeduction() {
		return donationDeduction;
	}
	public void setDonationDeduction(Double donationDeduction) {
		this.donationDeduction = donationDeduction;
	}
	public Double getShares_InsuranceDeduction() {
		return shares_InsuranceDeduction;
	}
	public void setShares_InsuranceDeduction(Double shares_InsuranceDeduction) {
		this.shares_InsuranceDeduction = shares_InsuranceDeduction;
	}
	public Double getPensionDeduction() {
		return pensionDeduction;
	}
	public void setPensionDeduction(Double pensionDeduction) {
		this.pensionDeduction = pensionDeduction;
	}
	public Double getHouseLoanInterestDeduction() {
		return houseLoanInterestDeduction;
	}
	public void setHouseLoanInterestDeduction(Double houseLoanInterestDeduction) {
		this.houseLoanInterestDeduction = houseLoanInterestDeduction;
	}
	public Double getTotalTaxSaving() {
		return totalTaxSaving;
	}
	public void setTotalTaxSaving(Double totalTaxSaving) {
		this.totalTaxSaving = totalTaxSaving;
	}
	public Double getActualTaxPayable() {
		return actualTaxPayable;
	}
	public void setActualTaxPayable(Double actualTaxPayable) {
		this.actualTaxPayable = actualTaxPayable;
	}
	public Double getTaxSavingPercent() {
		return taxSavingPercent;
	}
	public void setTaxSavingPercent(Double taxSavingPercent) {
		this.taxSavingPercent = taxSavingPercent;
	}
	public Double getPlannedTaxYearly() {
		return yPlannedTax;
	}
	public void setPlannedTaxYearly(Double yPlannedTax) {
		this.yPlannedTax = yPlannedTax;
	}
	public Double getPlannedTaxMonthly() {
		return mPlannedTax;
	}
	public void setPlannedTaxMonthly(Double mPlannedTax) {
		this.mPlannedTax = mPlannedTax;
	}
	public Double getExpectedPlannedTaxYearly() {
		return yExpectedPlannedTax;
	}
	public void setExpectedPlannedTaxYearly(Double yExpectedPlannedTax) {
		this.yExpectedPlannedTax = yExpectedPlannedTax;
	}
	public Double getExpectedPlannedTaxMonthly() {
		return mExpectedPlannedTax;
	}
	public void setExpectedPlannedTaxMonthly(Double mExpectedPlannedTax) {
		this.mExpectedPlannedTax = mExpectedPlannedTax;
	}
}

