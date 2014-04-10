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

}
