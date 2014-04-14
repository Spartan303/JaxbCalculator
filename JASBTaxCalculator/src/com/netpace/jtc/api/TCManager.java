package com.netpace.jtc.api;

public class TCManager {

	private static TCManager instance;
	private TaxAPIFactory mTaxAPIFactory;

	private TCManager() {
		mTaxAPIFactory = new TaxAPIFactory();
	}

	public static TCManager getInstance() {
		if (instance == null)
			return new TCManager();
		return instance;
	}

	public TaxResult calculateTax(Double income, InputType inputType,
			TaxAPIType type, int year) {

		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type, year);

		return taxAPI.calculateTax(income, inputType);
	}

	public TaxResult calculateImpactOfIncrement(Double income, Double increase,
			InputType inputType, TaxAPIType type, int year) {

		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type, year);

		return taxAPI.calculateImpactOfIncrement(income, increase, inputType);
	}

	public TaxResult calculateTaxPlanning(Double income, Double zakat,
			Double donation, Double shares, Double insurancePremium,
			Double pensionFund, int age, Double houseLoanInterest,
			InputType inputType, TaxAPIType type, int year) {

		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type, year);

		return taxAPI.calculateTaxPlanning(income, zakat, donation, shares,
				insurancePremium, pensionFund, age, houseLoanInterest,
				inputType);
	}
}
