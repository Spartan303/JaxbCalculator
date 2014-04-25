package com.netpace.jtc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.netpace.jtc.R;
import com.netpace.jtc.api.TaxResult;
import com.netpace.jtc.constants.AppConstants;
import com.netpace.jtc.ui.TypefaceTextView;

public class ImpactGoalsTabFragment extends Fragment {

	private static int NO_OF_ROWS = 0;

	private View mRootView;
	private String mTag;
	TableLayout mTableLayout;

	private TaxResult mTaxResult;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mTag = getArguments().getString("tabId");
		mTaxResult = (TaxResult) getArguments().getSerializable(
				AppConstants.TAX_RESULT);

		NO_OF_ROWS = (mTag.equals(AppConstants.TAB_ANNUALLY)) ? 8 : 8;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mRootView = inflater.inflate(R.layout.fragment_tab_impact_goals, null);
		mTableLayout = (TableLayout) mRootView.findViewById(R.id.tablelayout);

		if (mTag.equals(AppConstants.TAB_ANNUALLY))
			displayYearlyTab();
		else if (mTag.equals(AppConstants.TAB_MONTHLY))
			displayMonthlyTab();

		return mRootView;
	}

	private void displayYearlyTab() {
		for (int index = 0; index < NO_OF_ROWS; index++) {
			TableRow tableRow = (TableRow) LayoutInflater.from(getActivity())
					.inflate(R.layout.table_row, null);

			configureRowYearly(index, tableRow);

			mTableLayout.addView(tableRow);
		}
	}

	private void displayMonthlyTab() {
		for (int index = 0; index < NO_OF_ROWS; index++) {
			TableRow tableRow = (TableRow) LayoutInflater.from(getActivity())
					.inflate(R.layout.table_row, null);

			configureRowMonthly(index, tableRow);

			mTableLayout.addView(tableRow);
		}
	}

	private void configureRowYearly(int index, TableRow row) {

		if (row == null)
			return;

		TypefaceTextView leftTextView = (TypefaceTextView) row
				.findViewById(R.id.left_textView);
		TypefaceTextView rightTextView = (TypefaceTextView) row
				.findViewById(R.id.right_textView);

		switch (index) {
		case 0:
			leftTextView.setText("Taxable Salary");
			rightTextView.setText(mTaxResult.getTaxableIncomeYearly()
					.toString());
			break;
		case 1:
			leftTextView.setText("Expected Taxable Salary");
			rightTextView.setText(mTaxResult.getExpectedTaxableIncomeYearly()
					.toString());
			break;

		case 2:
			leftTextView.setText("Total Tax Payable");
			rightTextView.setText(mTaxResult.getTaxYearly().toString());
			break;

		case 3:
			leftTextView.setText("Expected Total Tax Payable");
			rightTextView.setText(mTaxResult.getExpectedTaxYearly().toString());
			break;

		case 4:
			leftTextView.setText("Take Home Salary");
			rightTextView.setText(mTaxResult.getTakeHomeIncomeYearly()
					.toString());
			break;

		case 5:
			leftTextView.setText("Expected Take Home Salary");
			rightTextView.setText(mTaxResult.getExpectedTakeHomeIncomeYearly()
					.toString());
			break;

		case 6:
			leftTextView.setText("Average Rate of Tax");
			rightTextView.setText(mTaxResult.getAvgRateOfTax().toString());
			break;

		case 7:
			leftTextView.setText("Expected Average Rate of Tax");
			rightTextView.setText(mTaxResult.getExpAvgRateOfTax().toString());
			break;

		default:
			break;
		}
	}

	private void configureRowMonthly(int index, TableRow row) {

		if (row == null)
			return;

		TypefaceTextView leftTextView = (TypefaceTextView) row
				.findViewById(R.id.left_textView);
		TypefaceTextView rightTextView = (TypefaceTextView) row
				.findViewById(R.id.right_textView);

		switch (index) {
		case 0:
			leftTextView.setText("Taxable Salary");
			rightTextView.setText(mTaxResult.getTaxableIncomeMonthly()
					.toString());
			break;
		case 1:
			leftTextView.setText("Expected Taxable Salary");
			rightTextView.setText(mTaxResult.getExpectedTaxableIncomeMonthly()
					.toString());
			break;

		case 2:
			leftTextView.setText("Total Tax Payable");
			rightTextView.setText(mTaxResult.getTaxMonthly().toString());
			break;

		case 3:
			leftTextView.setText("Expected Total Tax Payable");
			rightTextView.setText(mTaxResult.getExpectedTaxMonthly().toString());
			break;

		case 4:
			leftTextView.setText("Take Home Salary");
			rightTextView.setText(mTaxResult.getTakeHomeIncomeMonthly()
					.toString());
			break;

		case 5:
			leftTextView.setText("Expected Take Home Salary");
			rightTextView.setText(mTaxResult.getExpectedTakeHomeIncomeMonthly()
					.toString());
			break;

		case 6:
			leftTextView.setText("Average Rate of Tax");
			rightTextView.setText(mTaxResult.getAvgRateOfTax().toString());
			break;

		case 7:
			leftTextView.setText("Expected Average Rate of Tax");
			rightTextView.setText(mTaxResult.getExpAvgRateOfTax().toString());
			break;

		default:
			break;
		}
	}

}
