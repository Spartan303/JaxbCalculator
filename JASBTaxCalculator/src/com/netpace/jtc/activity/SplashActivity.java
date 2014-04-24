
package com.netpace.jtc.activity;

import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.netpace.jtc.R;
import com.netpace.jtc.info.VersionUtils;
import com.netpace.jtc.init.AppInit;
import com.netpace.jtc.log.Logger;
import com.netpace.jtc.model.Version;

/**
 * @author Deminem
 *
 */
public class SplashActivity extends FragmentActivity {

	protected static final String TAG = SplashActivity.class.getSimpleName();

	private TextView mBuildVersion;
	
	protected MyStateSaver data;

	/**
	 * {@inheritDoc}
	 * @see roboguice.activity.RoboFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		
		mBuildVersion = (TextView)findViewById(R.id.build_version);
		setBuildVersion();

		printAppHashKey();
		
		this.data = (MyStateSaver) getLastCustomNonConfigurationInstance();
		if (this.data == null) {
			this.data = new MyStateSaver();
		}
		if (this.data.doInit) {
			doInit();
		}
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		return super.onCreateView(name, context, attrs);
	}
		
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	protected void doInit() {
		this.data.doInit = false;
		final Handler handler = new Handler();
		final String currentVersion = VersionUtils.getVersionName(this);
		
		handler.postDelayed(new Runnable() {
			public void run() {
				try {
					
					// Initialize configuration
					AppInit.getInstance().init(getApplicationContext());
					
					// Check if it's update or already installed.
					Version installedVersion = VersionUtils.getInstalledVersion();
					Version newVersion = null;
					String createdDateTime = (new Date()).toString();
					
					// first time installed
					if (installedVersion == null) {
						newVersion = new Version(currentVersion, createdDateTime);
					}
					else {
						if (installedVersion.getVersionName() != null && 
								!installedVersion.getVersionName().equalsIgnoreCase(currentVersion)) {
							
							// updated app version
							newVersion = new Version(currentVersion, createdDateTime);
						}
					}
					
					// Update the new version
					if (newVersion != null) {
						VersionUtils.setInstalledVersion(newVersion);
					}

					// start the app.
					startApp();
					
				} catch( Exception e ) {
					throw new RuntimeException(e);
				}
			}
		}, 1000);
	}

	private class MyStateSaver {
		public boolean doInit = true;
	}
	
	/**
	 * ============================ 
	 * Action Methods 
	 * ============================
	 */
	public void startApp() {
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	/**
	 * ============================ 
	 * Private Methods 
	 * ============================
	 */
	private void setBuildVersion() {
		
		try {
			if (mBuildVersion != null) {
				String buildVersion = "Build version : " + VersionUtils.getVersionName(this);
				mBuildVersion.setText(buildVersion);
			}
		} catch (Exception e) {
			Logger.log(TAG, e.getLocalizedMessage());
		}
	}
	
	private void printAppHashKey() {
		try {
			String hashKey = VersionUtils.getAppHashKey(this);
			Logger.log(hashKey, "App Hash Key " + hashKey);
			
		} catch (Exception e) {
			Logger.log(TAG, "Exception: " + e.getLocalizedMessage());
		}
	}
}
