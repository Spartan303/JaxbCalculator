package com.netpace.jtc.ui;

import com.netpace.jtc.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <p>A custom <code>TextView</code> that displays text using a custom
 * <code>Typeface</code> that can be set in your XML layout.</p>
 * 
 * <p>To use the custom view attributes in your layout, you'll need to first
 * declare the custom namespace using the xmlns directive:</p>
 * 
 * <code><pre>
 *   &lt;?xml version="1.0" encoding="utf-8"?&gt;
 *   &lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *       xmlns:simple="http://schemas.android.com/apk/res/com.simple"
 *       android:layout_width="match_parent"
 *       android:layout_height="match_parent"
 *       android:orientation="vertical" &gt;
 *      
 *       &lt;com.simple.widget.TypefaceTextView
 *           android:layout_width="wrap_content"
 *           android:layout_height="wrap_content"
 *           simple:typeface="GothamMediumTabular"
 *           android:text="Hello, Gotham!" /&gt;
 *   
 *   &lt;/LinearLayout&gt;</pre></code>
 * 
 * <p>You can then set the typeface by providing the prefix of the desired
 * typeface file with the <code>simple:typeface</code> attribute.</p>
 * 
 * <p>Your typeface resources should be saved to the <code>assets/fonts</code>
 * directory of your project.</p>
 * 
 * <p>Files should include the suffix <code>-Family.otf</code>
 * (e.g. <code>Helvetica-Family.otf</code>).</p>
 * 
 * @author Adnan Urooj (Deminem)
 */
public class TypefaceTextView extends TextView {
	
	/** An <code>LruCache</code> for previously loaded typefaces. */
	private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(
			12);

	public TypefaceTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// Get our custom attributes
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.TypefaceTextView, 0, 0);

		try {
			String typefaceName = a.getString(R.styleable.TypefaceTextView_typeface);

			if (!isInEditMode() && !TextUtils.isEmpty(typefaceName)) {
				Typeface typeface = sTypefaceCache.get(typefaceName);

				if (typeface == null) {
					typeface = Typeface.createFromAsset(context.getAssets(),
							String.format("fonts/%s.ttf", typefaceName));

					// Cache the Typeface object
					sTypefaceCache.put(typefaceName, typeface);
				}
				setTypeface(typeface);

				// Note: This flag is required for proper typeface rendering
				setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
			}
		} 
		finally {
			a.recycle();
		}
	}
	
	public static Typeface getTypeface(String typefaceFamily) {
		
		if (!TextUtils.isEmpty(typefaceFamily)) {
			Typeface typeface = sTypefaceCache.get(typefaceFamily);
			return typeface;
		}
		
		return null;
	}
}
