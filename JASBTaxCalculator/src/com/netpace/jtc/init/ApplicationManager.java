package com.netpace.jtc.init;

import android.app.Application;
import android.content.Context;

public class ApplicationManager extends Application {
	 
	 protected static final String TAG = ApplicationManager.class.getSimpleName();
	 
	 private static Context context;
	 
	 public void onCreate() {
	  super.onCreate();

	  context = getApplicationContext();
	 }

	 public static Context getAppContext() {
	  return context;
	 }
}
