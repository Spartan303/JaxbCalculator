package com.netpace.jtc.info;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;

import com.netpace.jtc.init.ApplicationManager;
import com.netpace.jtc.log.Logger;
import com.netpace.jtc.model.Version;
import com.netpace.jtc.util.Util;

public class VersionUtils {

	protected static final String TAG = VersionUtils.class.getSimpleName();

	private static final int SESSION_KEY_BUFFER_LEN = 250;
	
	private static String VERSION_KEY = "versionKey";
	
	/**
	 * @param context
	 * @return
	 * @throws NameNotFoundException
	 */
	public static int getVersionCode( Context context ) throws NameNotFoundException {
		PackageInfo manager= context.getPackageManager().getPackageInfo(
				context.getPackageName(), 0);
	    return manager.versionCode;
	}
	
	/**
	 * @param context
	 * @return
	 * @throws NameNotFoundException
	 */
	public static String getVersionName( Context context ) {
		
		String verion = null;
		try {
			PackageInfo manager= context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			
			verion = manager.versionName;
			
		} catch (Exception e) {
			Logger.log(TAG, e.getLocalizedMessage());
		}

	    return verion;
	}
	
	/**
	 * @param context
	 * @return
	 * @throws NameNotFoundException
	 */
	public static String getAppHashKey( Context context ) {

		String hashKey = null;
		try {
			PackageInfo manager = context.getPackageManager().getPackageInfo(
					context.getPackageName(), PackageManager.GET_SIGNATURES);
			
			for (Signature signature : manager.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());

				hashKey = Base64.encodeToString(md.digest(), Base64.DEFAULT);
			}

		} catch (NameNotFoundException e) {
			Logger.log(TAG, e.getLocalizedMessage());

		} catch (NoSuchAlgorithmException e) {
			Logger.log(TAG, e.getLocalizedMessage());
		}

		return hashKey;
	}
	
	public static void setInstalledVersion(Version version) {
		
		if (version != null) {
			try {
				Context ctx = ApplicationManager.getAppContext();
				FileOutputStream fos = ctx.openFileOutput(VERSION_KEY, Context.MODE_PRIVATE);
				ObjectOutputStream os = new ObjectOutputStream(fos);
				os.writeObject( version );
				os.close();
				
			} catch (Exception e) {
				Logger.log(TAG, "Exception : " + e.toString());
			}
		}
	}
	
	public static Version getInstalledVersion() {

		try {
			Context ctx = ApplicationManager.getAppContext();
			if (Util.fileExistance(ctx, VERSION_KEY)) {
				FileInputStream fis = ctx.openFileInput(VERSION_KEY);
				ObjectInputStream is = new ObjectInputStream(fis);
				Version version = (Version) is.readObject();
				is.close();

				return version;
			}
		} catch (Exception e) {
			Logger.log(TAG, "Exception : " + e.toString());
		}
		
		return null;
	}
	
	public static void updateInstalledVersion(Version version) {
		
		if (version != null) {
			try {
				Context ctx = ApplicationManager.getAppContext();
				FileOutputStream fos = ctx.openFileOutput(VERSION_KEY, Context.MODE_PRIVATE);
				ObjectOutputStream os = new ObjectOutputStream(fos);
				os.writeObject( version );
				os.close();
				
			} catch (Exception e) {
				Logger.log(TAG, "Exception : " + e.toString());
			}
		}
	}
}
