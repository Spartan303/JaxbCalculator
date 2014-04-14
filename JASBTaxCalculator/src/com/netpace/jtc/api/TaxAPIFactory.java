package com.netpace.jtc.api;


public class TaxAPIFactory {

	public TaxAPI getTaxAPI(TaxAPIType type, int year) {

		switch(type) {
			case SALARIED : return new SalariedTaxAPI(year);
			case NON_SALARIED : return new NonSalariedTaxAPI();
			default : return null;
		}
	}
}