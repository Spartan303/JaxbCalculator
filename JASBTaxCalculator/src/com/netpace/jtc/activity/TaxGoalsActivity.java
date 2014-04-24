package com.netpace.jtc.activity;

import com.netpace.jtc.R;
import com.netpace.jtc.api.TaxResult;
import com.netpace.jtc.constants.AppConstants;
import com.netpace.jtc.fragments.TaxGoalsFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class TaxGoalsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tax_result);

		if (savedInstanceState == null) {
			
			TaxResult mTaxResult = (TaxResult) getIntent().getSerializableExtra(AppConstants.TAX_RESULT);
			Bundle args = new Bundle(); 
			args.putSerializable(AppConstants.TAX_RESULT, mTaxResult);
			
			Fragment fragment = new TaxGoalsFragment();
			fragment.setArguments(args);
			
			FragmentManager fm = getSupportFragmentManager();
			fm.beginTransaction()
					.add(R.id.container, fragment).commit();
		}
	}

}
