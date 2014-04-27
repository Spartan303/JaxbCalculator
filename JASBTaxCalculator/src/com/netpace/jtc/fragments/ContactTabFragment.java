package com.netpace.jtc.fragments;

import com.netpace.jtc.R;
import com.netpace.jtc.ui.TypefaceTextView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactTabFragment extends Fragment {

	private View mRootView;
	private String mTag;
	TypefaceTextView mDays1Tv;
	TypefaceTextView mDays2Tv;
	TypefaceTextView mTiming1Tv;
	TypefaceTextView mTiming2Tv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTag = getArguments().getString("tabId");
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_tab_contact_us, null);
		
		
		mDays1Tv =  (TypefaceTextView) mRootView.findViewById(R.id.days_text1);
		mDays2Tv =  (TypefaceTextView) mRootView.findViewById(R.id.days_text2);
		mTiming1Tv =  (TypefaceTextView) mRootView.findViewById(R.id.timing1);
		mTiming2Tv =  (TypefaceTextView) mRootView.findViewById(R.id.timing2);
		
		if(mTag.equals(getString(R.string.karachi_office))) {
			mDays1Tv.setText(getString(R.string.days1_karachi_office));
			mDays2Tv.setText(getString(R.string.days2_karachi_office));
			mTiming1Tv.setText(getString(R.string.timing1_karachi_office));
			mTiming2Tv.setText(getString(R.string.timing2_karachi_office));
		}
		else if(mTag.equals(getString(R.string.islamabad_office))) {
			mDays1Tv.setText(getString(R.string.days1_islamabad_office));
			mDays2Tv.setText(getString(R.string.days2_islamabad_office));
			mTiming1Tv.setText(getString(R.string.timing1_islamabad_office));
			mTiming2Tv.setText(getString(R.string.timing2_islamabad_office));		
		}

		return mRootView;
	}
	
	

	
}
