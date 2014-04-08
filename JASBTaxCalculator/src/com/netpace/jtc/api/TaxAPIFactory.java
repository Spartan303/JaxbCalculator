package com.netpace.jtc.api;

import com.netpace.jtc.enums.TaxAPIType;

public class TaxAPIFactory {

	public TaxAPI getTaxAPI(TaxAPIType type) {

		switch(type) {
			case SALARIED : return new SalariedTaxAPI();
			case NON_SALARIED : return new NonSalariedTaxAPI();
			default : return null;
		}
	}
}