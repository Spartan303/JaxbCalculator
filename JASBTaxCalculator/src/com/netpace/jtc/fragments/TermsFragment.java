package com.netpace.jtc.fragments;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.netpace.jtc.R;
import com.netpace.jtc.constants.AppConstants;

public class TermsFragment extends Fragment {
	
	private String filePath = "file:///android_asset/TermsOfUse.html";
	private WebView webView;
	
	public TermsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_terms, container, false);
        
        this.webView = ((WebView) rootView.findViewById(R.id.webViewTemrsOfUse));
        this.webView.setWebViewClient(new Callback());
		this.webView.getSettings().setBuiltInZoomControls(false);
		this.webView.getSettings().setLoadWithOverviewMode(false);
		this.webView.getSettings().setUseWideViewPort(false);
		this.webView.loadUrl(filePath);
        
        return rootView;
    }
	
	private class Callback extends WebViewClient {

		@Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if( url.startsWith("http:") || url.startsWith("https:") ) {
                return false;
            }

            // Otherwise allow the OS to handle it
            else if (url.startsWith("tel:")) { 
                Intent tel = new Intent(Intent.ACTION_DIAL, Uri.parse(url)); 
                startActivity(tel);
                return true;
            }
            else if (url.startsWith("mailto:")) {
//                String body = "Enter your Question, Enquiry or Feedback below:\n\n";
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.setType("application/octet-stream");
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{AppConstants.SUPPORT_EMAIL_ADDRESS});
//                mail.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//                mail.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(mail);
                return true;
                }
            return true;
        }
	}
}
