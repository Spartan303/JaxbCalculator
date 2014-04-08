package com.netpace.jtc.api;

import com.netpace.jtc.enums.TaxAPIType;

public class TCManager {
	
	private static final double NO_OF_MONTHS = 12;
	private static TCManager instance;
	private TaxAPIFactory mTaxAPIFactory;
	
	private TCManager() { 
		mTaxAPIFactory = new TaxAPIFactory();
	}
	
	public static TCManager getInstance() {
		if(instance == null)
			return new TCManager();
		return instance;
	}
	
//	Utility Methods take input yearly or monthly depending on what view sends it...
// 	All the logical calculations are done in TaxAPI (Salaried or Non Salaried), here only api is consumed but but but...
// 	Utility Methods does the conversion part of monthly or yearly before or after calculation
// 	TaxAPI calculates on yearly values...
	
	public double calcTaxableIncomeMonthly(TaxAPIType type, double income, double zakat) {
		
		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);
		
		double yearlyIncome = income * NO_OF_MONTHS; // yearly income for sending to the API 
		double taxableIncome = taxAPI.getTaxableIncome(yearlyIncome, zakat);
		return taxableIncome/NO_OF_MONTHS;
	}
	
	public double calcTaxableIncomeYearly(TaxAPIType type, double income, double zakat) {
		
		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);
		
		return taxAPI.getTaxableIncome(income, zakat);
	}
	
	public double calcExpectedTaxableIncomeMonthly(TaxAPIType type, double income, double increase, double zakat) {
		
		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);
		double newIncomeYearly =  taxAPI.getExpectedIncome(income, increase) * NO_OF_MONTHS;
		double newTaxableIncome = taxAPI.getTaxableIncome(newIncomeYearly, zakat);
		
		return newTaxableIncome/NO_OF_MONTHS;
	}
	
	public double calcExpectedTaxableIncomeYearly(TaxAPIType type, double income, double increase, double zakat) {
		
		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);
		double newIncomeYearly =  taxAPI.getExpectedIncome(income, increase);
		
		return taxAPI.getTaxableIncome(newIncomeYearly, zakat);
	}
	
	

	


}
