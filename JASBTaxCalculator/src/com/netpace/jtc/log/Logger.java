package com.netpace.jtc.log;

import android.util.Log;

import com.netpace.jtc.constants.AppConstants;

public class Logger {

	public static void log(String TAG, String msg) {
		if (AppConstants.DEBUG) {
			Log.d(TAG, msg);
		}
	}
}
