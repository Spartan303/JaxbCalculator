package com.netpace.jtc.fragments;

import com.netpace.jtc.R;
import com.netpace.jtc.api.InputType;
import com.netpace.jtc.api.TCManager;
import com.netpace.jtc.api.TaxAPIType;
import com.netpace.jtc.api.TaxResult;
import com.netpace.jtc.constants.AppConstants;
import com.netpace.jtc.controller.NavigationController;
import com.netpace.jtc.ui.TypefaceEditText;
import com.netpace.jtc.ui.TypefaceTextView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class ImpactOfIncrementFragment extends Fragment implements OnTabChangeListener {
	private static final String TAG = "Impact-Of-Increment";
	
	public static final String TAB_ANNUALLY = "Annually";
	public static final String TAB_MONTHLY = "Monthly";

	private View mRootView;
	private TabHost mTabHost;
	private int mCurrentTab;
	
	private Button mCalcImpactButton;
	
	private Double income;
	private Double increment;
	private TaxResult mTaxResult;
	
	public ImpactOfIncrementFragment() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        mRootView = inflater.inflate(R.layout.fragment_tax_impact, container, false);
        
		mTabHost = (TabHost) mRootView.findViewById(android.R.id.tabhost);
		mTabHost.setup();

		setupTab(new TextView(getActivity()), TAB_ANNUALLY);
		setupTab(new TextView(getActivity()), TAB_MONTHLY);
		
		mCalcImpactButton = (Button) mRootView.findViewById(R.id.calc_impact_button);
		mCalcImpactButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				ImpactFragment frag = (ImpactFragment) getFragmentManager()
						.findFragmentById(R.id.display_content);

				if (frag != null) {
					TypefaceEditText incomeTxtField = frag.getIncomeTextField();
					TypefaceEditText incrementTxtField = frag.getIncrementTextField();
					
					income = getValue(incomeTxtField);
					increment = getValue(incrementTxtField);
					
					if (income <= 0 ) {
						incomeTxtField.setError("Invalid Input");
					} else {
						mTaxResult = calculateImpactOfIncrement();

						NavigationController.getInstance()
								.startImpactGoalsActivity(getActivity(),
										mTaxResult);
					}
				}
			}

			private Double getValue(TypefaceEditText TxtField) {
				// if blank txtField Value then 0 value else convert to Double
				// value and return
				return (TxtField.getText().toString().equals("")) ? 0d
						: Double.parseDouble(TxtField.getText()
								.toString());
			}

			private TaxResult calculateImpactOfIncrement() {

				if (mCurrentTab == 0) {
					return TCManager.getInstance().calculateImpactOfIncrement(income, increment,
							InputType.YEARLY, TaxAPIType.SALARIED, 2014);
				} else {
					return TCManager.getInstance().calculateImpactOfIncrement(income, increment,
							InputType.MONTHLY, TaxAPIType.SALARIED, 2014);
				}
			}
		});
		
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
		View view = (text.equals(AppConstants.TAB_ANNUALLY)) ? 
				LayoutInflater.from(context).inflate(R.layout.tab_annually, null) : 
				LayoutInflater.from(context).inflate(R.layout.tab_monthly, null);
				
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
			fragment = new ImpactFragment();
			args.putString("tabId", tabId);
		}
		else if(tabId == TAB_ANNUALLY) {
			fragment = new ImpactFragment();
			args.putString("tabId", tabId);
		}
		
		fragment.setArguments(args);

		FragmentManager fm = getFragmentManager();
		fm.beginTransaction()
				.replace(R.id.display_content, fragment)
				.commit();
	}


}


