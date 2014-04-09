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

	public TaxResult getTaxCalculationResult(TaxAPIType type, double income,
			double increase, double zakat, double donation, double shares,
			double insurancePremium, double pensionFund, int age,
			double houseLoanInterest, InputType inputType) {

		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);

		return taxAPI.getTaxCalculationResult(income, increase, zakat,
				donation, shares, insurancePremium, pensionFund, age,
				houseLoanInterest, inputType);
	}
	
	public TaxResult getTaxCalculationResult(TaxAPIType type, double income,
			double increase, double zakat, InputType inputType) {

		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);

		return taxAPI.getTaxCalculationResult(income, increase, zakat, inputType);
	}
}
