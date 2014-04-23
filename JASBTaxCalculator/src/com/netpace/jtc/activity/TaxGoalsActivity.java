package com.netpace.jtc.activity;

import com.netpace.jtc.R;
import com.netpace.jtc.fragments.TaxGoalsFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class TaxGoalsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tax_result);

		if (savedInstanceState == null) {
			FragmentManager fm = getSupportFragmentManager();
			fm.beginTransaction()
					.add(R.id.container, new TaxGoalsFragment()).commit();
		}
	}

}
