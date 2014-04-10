package com.netpace.jtc.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netpace.jtc.R;
import com.netpace.jtc.api.InputType;
import com.netpace.jtc.api.TCManager;
import com.netpace.jtc.api.TaxAPIType;
import com.netpace.jtc.api.TaxResult;

public class TaxCalculatorFragment extends Fragment {
	
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
		
	}

	private TaxResult calculateResult() {
        double income = 50000;
        double increase = 0;
        double zakat = 0;
		return null;
        
//        return TCManager.getInstance().
	} 
}
