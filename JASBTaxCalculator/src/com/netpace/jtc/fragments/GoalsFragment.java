package com.netpace.jtc.fragments;

import com.netpace.jtc.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GoalsFragment extends Fragment {
	public static final String TAB_MONTHLY = "Monthly";
	public static final String TAB_ANNUALLY = "Annually";
	
	private View mRootView;
	private String mTag;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTag = getArguments().getString("tabId");	
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_tab_goals, null);

		return mRootView;
	}
}
