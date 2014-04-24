package com.netpace.jtc.init;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * @author Michenux
 * 
 */
public class AppInit {

	/**
	 * App init
	 */
	private static final AppInit instance = new AppInit();

	private boolean preInitialized = false;

	private AppInit() {

	}

	public static AppInit getInstance() {
		return instance;
	}

	/**
	 * @param context
	 * @throws NameNotFoundException
	 */
	public void init(Context context) {

		preInitialized = true;
	}

	public boolean isPreInitialized() {
		return preInitialized;
	}
}
