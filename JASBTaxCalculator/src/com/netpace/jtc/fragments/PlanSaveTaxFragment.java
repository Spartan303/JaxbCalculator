package com.netpace.jtc.fragments;

import android.support.v4.app.Fragment;
import android.text.Html;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.netpace.jtc.R;
import com.netpace.jtc.constants.AppConstants;

public class PlanSaveTaxFragment extends Fragment {
	
	TextView planSaveTaxTextView;
	EditText emailEditText;
	Button submitButton;
	public static final CharSequence PLAN_SAVE_TAX_CONTENT = Html
			.fromHtml(AppConstants.PLAN_SAVE_TAX_CONTENT);
	
	public PlanSaveTaxFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_plan_save_tax, container, false);
         
        return rootView;
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initUIComponents();

		submitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String email = emailEditText.getText().toString();
				if (!email.contains("@") && email.length() > 0)
					emailEditText.setError("Invalid Email Address");
				else if (email.length() <= 0)
					emailEditText.setError("Required");
				else
					System.out.println("Submitted");
			}
		});

	}

	private void initUIComponents() {
		planSaveTaxTextView = (TextView) getView().findViewById(R.id.PlanSaveTaxTextView);
		emailEditText = (EditText) getView().findViewById(R.id.EmailEditText);
		submitButton = (Button) getView().findViewById(R.id.SubmitButton);
		planSaveTaxTextView.setText(PLAN_SAVE_TAX_CONTENT);
	}
}
