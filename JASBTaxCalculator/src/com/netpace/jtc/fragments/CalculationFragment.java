package com.netpace.jtc.fragments;

import com.netpace.jtc.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalculationFragment extends Fragment {

	private static final String TAG = "FragmentTabs";
	private View mRoot;
	
	public CalculationFragment() { }
	
	public CalculationFragment(String tabId) {
		
	}

//	@Override
//	public void onAttach(Activity activity) {
//		super.onAttach(activity);
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRoot = inflater.inflate(R.layout.fragment_tab_content, null);
		
		return mRoot;
	}


}
