package com.netpace.jtc.fragments;

import com.netpace.jtc.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ImpactFragment extends Fragment {

	public static final String TAB_MONTHLY = "Monthly";
	public static final String TAB_ANNUALLY = "Annually";

	private View mRootView;
	private String mTag;

	private EditText mIncomeEditText;
	private EditText mIncrementEditText;
//	private Double income;
//	private Double increment;

	public ImpactFragment() {	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTag = getArguments().getString("tabId");
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_tab_impact, null);

		initUIComponents();

		return mRootView;
	}

	private void initUIComponents() {
		mIncomeEditText = (EditText) mRootView.findViewById(R.id.income_text);
		mIncrementEditText = (EditText) mRootView.findViewById(R.id.increment_text);
		setHint();
	}

	private void setHint() {
		if(mTag.equals(TAB_MONTHLY)) { 
			mIncomeEditText.setHint("Enter Monthly Taxbale Income");
			mIncrementEditText.setHint("Enter Monthly Increment");
		}
		else if(mTag.equals(TAB_ANNUALLY)) { 
			mIncomeEditText.setHint("Enter Annual Taxable Income");
			mIncrementEditText.setHint("Enter Annual Increment");
		}
	}
}