package com.netpace.jtc.fragments;

import com.netpace.jtc.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class TabsFragment extends Fragment implements OnTabChangeListener {

	private static final String TAG = "Tax-Calculator";
	
	public static final String TAB_ANNUALLY = "Annually";
	public static final String TAB_MONTHLY = "Monthly";
	
	private View mRootView;
	private TabHost mTabHost;
	private int mCurrentTab;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_tabs, null);
		mTabHost = (TabHost) mRootView.findViewById(android.R.id.tabhost);
		setupTabs();
		return mRootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(false);

		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(mCurrentTab);
		// manually start loading stuff in the first tab
		updateTab(TAB_ANNUALLY, R.id.tab_annually);
	}

	private void setupTabs() {
		mTabHost.setup(); // you must call this before adding your tabs!
//		mTabHost.addTab(newTab(TAB_MONTHLY, R.string.tab_monthly, R.id.tab_monthly));
		mTabHost.addTab(newTab(TAB_ANNUALLY, R.string.tab_annually, R.id.tab_annually));
	}
	
	private TabSpec newTab(String tag, int labelId, int tabContentId) {
		
		Log.d(TAG, "buildTab(): tag=" + tag);

		View indicator = LayoutInflater.from(getActivity()).inflate(R.layout.tab,
								(ViewGroup) mRootView.findViewById(android.R.id.tabs), false);
		
		((TextView) indicator.findViewById(R.id.text)).setText(labelId);
		
		TabSpec tabSpec = mTabHost.newTabSpec(tag);		
		tabSpec.setIndicator(indicator);
		tabSpec.setContent(tabContentId);
		
		return tabSpec;
	}

	@Override
	public void onTabChanged(String tabId) {
		Log.d(TAG, "onTabChanged(): tabId=" + tabId);
		if (TAB_ANNUALLY.equals(tabId)) {
			updateTab(tabId, R.id.tab_annually);
			mCurrentTab = 0;
			return;
		}
		if (TAB_MONTHLY.equals(tabId)) {
			updateTab(tabId, R.id.tab_monthly);
			mCurrentTab = 1;
			return;
		}
	}

	private void updateTab(String tabId, int placeholder) {
		FragmentManager fm = getFragmentManager();
		if (fm.findFragmentByTag(tabId) == null) {
			fm.beginTransaction()
					.replace(placeholder, new CalculationFragment(tabId), tabId)
					.commit();
		}
	}
}
