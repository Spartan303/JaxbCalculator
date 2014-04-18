package com.netpace.jtc.fragments;

import com.netpace.jtc.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TaxCalculatorFragment extends Fragment {

	private static final String TAG = "Tax-Calculator";
	
	public TaxCalculatorFragment() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_tax_calculator, container, false);
        
        displayFragment();
         
        return rootView;
    }

	private void displayFragment() {
		Fragment fragment = new TabsFragment();		
		FragmentManager fragmentManager = getChildFragmentManager();
		fragmentManager.beginTransaction()
				.add(R.id.tabs_fragment, fragment).commit();
	}
}
