package com.netpace.jtc.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.netpace.jtc.R;
import com.netpace.jtc.api.TaxResult;
import com.netpace.jtc.constants.AppConstants;
import com.netpace.jtc.fragments.ImpactGoalsFragment;

public class ImpactGoalsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_impact_goals);
		

		if (savedInstanceState == null) {
			
			TaxResult mTaxResult = (TaxResult) getIntent().getSerializableExtra(AppConstants.TAX_RESULT);
			Bundle args = new Bundle(); 
			args.putSerializable(AppConstants.TAX_RESULT, mTaxResult);
			
			Fragment fragment = new ImpactGoalsFragment();
			fragment.setArguments(args);
			
			FragmentManager fm = getSupportFragmentManager();
			fm.beginTransaction()
					.add(R.id.container, fragment).commit();
		}
	}

}
