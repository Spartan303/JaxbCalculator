package com.netpace.jtc.fragments;

import com.netpace.jtc.R;
import com.netpace.jtc.ui.TypefaceTextView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GoalsFragment extends Fragment {
	public static final String TAB_MONTHLY = "Monthly";
	public static final String TAB_ANNUALLY = "Annually";
	private static int NO_OF_ROWS = 0;

	private View mRootView;
	private String mTag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTag = getArguments().getString("tabId");
		NO_OF_ROWS = (mTag.equals(TAB_ANNUALLY)) ? 5 : 5;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mRootView = inflater.inflate(R.layout.fragment_tab_goals, null);
		TableLayout mTableLayout = (TableLayout) mRootView
				.findViewById(R.id.tablelayout);

		for (int index = 0; index < NO_OF_ROWS; index++) {
			TableRow tableRow = (TableRow) LayoutInflater.from(getActivity())
					.inflate(R.layout.table_row, null);
			configureRow(index, tableRow);
			mTableLayout.addView(tableRow);
		}

		return mRootView;
	}

	private void configureRow(int index, TableRow row) {

		if (row == null)
			return;

		TypefaceTextView leftTextView = (TypefaceTextView) row
				.findViewById(R.id.left_textView);
		TypefaceTextView rightTextView = (TypefaceTextView) row
				.findViewById(R.id.right_textView);

		switch (index) {
		case 0:
			leftTextView.setText("Taxable Income");
			rightTextView.setText("600,000");
			break;
		case 1:
			leftTextView.setText("After Deductions");
			rightTextView.setText("600,000");
			break;

		case 2:
			leftTextView.setText("Total Tax Payable");
			rightTextView.setText("10,000");
			break;
		case 3:
			leftTextView.setText("Take Home Salary");
			rightTextView.setText("590,000");
			break;

		case 4:
			leftTextView.setText("Average Rate of Tax");
			rightTextView.setText("2.0%");
			break;

		default:
			break;
		}
	}
}
