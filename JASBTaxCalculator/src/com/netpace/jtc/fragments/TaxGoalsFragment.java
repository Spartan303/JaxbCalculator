package com.netpace.jtc.fragments;

import com.netpace.jtc.R;
import com.netpace.jtc.ui.TypefaceTextView;

import android.content.Context;
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
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class TaxGoalsFragment extends Fragment implements OnTabChangeListener {
	
	private static final String TAG = "Tax-Goals";
	
	public static final String TAB_ANNUALLY = "Annually";
	public static final String TAB_MONTHLY = "Monthly";

	private View mRootView;
	private TabHost mTabHost;
	private int mCurrentTab;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_tax_result,
				container, false);
		
		mTabHost = (TabHost) mRootView.findViewById(android.R.id.tabhost);
		mTabHost.setup();

		setupTab(new TextView(getActivity()), TAB_ANNUALLY);
		setupTab(new TextView(getActivity()), TAB_MONTHLY);
		
		
		return mRootView;
	}

	private void setupTab(final View view, final String tag) {
		View tabview = createTabView(mTabHost.getContext(), tag);
	        TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview).setContent(new TabContentFactory() {
			public View createTabContent(String tag) {return view;}
		});

		mTabHost.addTab(setContent);
	}

	private static View createTabView(final Context context, final String text) {
		View view = LayoutInflater.from(context).inflate(R.layout.tab, null);
		TypefaceTextView tv = (TypefaceTextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(false);

		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(mCurrentTab);
		
		// manually start loading stuff in the first tab
		updateTab(TAB_ANNUALLY, R.id.display_content);
	}

	@Override
	public void onTabChanged(String tabId) {
		Log.d(TAG, "onTabChanged(): tabId=" + tabId);
		if (TAB_ANNUALLY.equals(tabId)) {
			updateTab(tabId, R.id.display_content);
			mCurrentTab = 0;
			return;
		}
		if (TAB_MONTHLY.equals(tabId)) {
			updateTab(tabId, R.id.display_content);
			mCurrentTab = 1;
			return;
		}
	}

	private void updateTab(String tabId, int placeholder) {
		Log.d(TAG, "update Tab: tabId=" + tabId);

		Fragment fragment = null;
		Bundle args = new Bundle();

		if(tabId == TAB_MONTHLY) {
			fragment = new GoalsFragment();
			args.putString("tabId", tabId);
		}
		else if(tabId == TAB_ANNUALLY) {
			fragment = new GoalsFragment();
			args.putString("tabId", tabId);
		}
		
		fragment.setArguments(args);

		FragmentManager fm = getFragmentManager();
		fm.beginTransaction()
				.replace(R.id.display_content, fragment)
				.commit();
	}
}