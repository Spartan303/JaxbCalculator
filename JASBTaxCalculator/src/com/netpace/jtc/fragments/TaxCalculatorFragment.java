package com.netpace.jtc.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netpace.jtc.R;
import com.netpace.jtc.api.InputType;
import com.netpace.jtc.api.TCManager;
import com.netpace.jtc.api.TaxAPIType;
import com.netpace.jtc.api.TaxResult;

public class TaxCalculatorFragment extends Fragment {

	private static final String TAG = "Tax-Calculator";

	public TaxCalculatorFragment() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_tax_calculator,
				container, false);

		TaxResult result = calculateResult();

		return rootView;
	}

	private TaxResult calculateResult() {
		Double income = 2800000d;
		Double zakat = 250000d;
		Double donation = 10000d;
		Double shares = 100000d;
		Double insurancePremium = 20000d;
		Double houseLoanInterest = 200000d;
		Double pensionFund = 100000d;
		int age = 46;
		
		return TCManager.getInstance().calculateTaxPlanning(income, zakat,
				donation, shares, insurancePremium, pensionFund, age,
				houseLoanInterest, InputType.YEARLY, TaxAPIType.SALARIED, 2014);
	}
}
