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

	public TaxCalculatorFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_tax_calculator, container, false);
        
        TaxResult result = calculateResult();
        displayResult(result);
        
        return rootView;
    }
	
	private void displayResult(TaxResult result) {
		Log.i(TAG, result.getTaxYearly().toString());
	}

	private TaxResult calculateResult() {
        Double income = 50000d;

		return TCManager.getInstance().calculateTax(income, InputType.MONTHLY, TaxAPIType.SALARIED);
	} 
}
