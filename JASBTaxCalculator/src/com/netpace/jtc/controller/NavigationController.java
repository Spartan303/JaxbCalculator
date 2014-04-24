package com.netpace.jtc.controller;

import com.netpace.jtc.R;
import com.netpace.jtc.activity.TaxGoalsActivity;
import com.netpace.jtc.api.TaxResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;


public class NavigationController {

	protected static final String TAG = NavigationController.class.getSimpleName();
	
	public static NavigationController instance = new NavigationController();

	private NavigationController() { }
	
	public static NavigationController getInstance() {
		return instance;
	}

	
	public void startTaxGoalsActivity(FragmentActivity context, TaxResult mTaxResult) {
		
		Intent intent = new Intent(context, TaxGoalsActivity.class);
		intent.putExtra("tax_result", mTaxResult);
		startActivity(context, intent);
	}
	
	public void startActivity(Context ctx, Intent intent, boolean isFinished) {
		if (ctx != null) {
			ctx.startActivity(intent);
			((Activity) ctx).overridePendingTransition(R.anim.appear, R.anim.disappear);
			
			if (isFinished) {
				finishActivity(ctx);
			}
		}
	}
	
	public void startActivity(Context ctx, Intent intent) {
		startActivity(ctx, intent, false);
	}
	
	
	public void finishActivity(Context ctx) {
		
		if (ctx != null) {
			((Activity) ctx).finish();
			((Activity) ctx).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	}
	
}
