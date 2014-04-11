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

	public TaxResult calculateTax(double income, InputType inputType,
			TaxAPIType type) {

		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);

		return taxAPI.calculateTax(income, inputType);
	}

	public TaxResult calculateImpactOfIncrement(double income, double increase,
			InputType inputType, TaxAPIType type) {

		TaxAPI taxAPI = mTaxAPIFactory.getTaxAPI(type);

		return taxAPI.calculateImpactOfIncrement(income, increase, inputType);
	}

}
