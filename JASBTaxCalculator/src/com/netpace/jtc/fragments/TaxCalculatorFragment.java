package com.netpace.jtc.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netpace.jtc.R;
import com.netpace.jtc.api.InputType;
import com.netpace.jtc.api.TCManager;
import com.netpace.jtc.api.TaxAPIType;
import com.netpace.jtc.api.TaxResult;

public class TaxCalculatorFragment extends Fragment {

	private static final String TAG = "Tax-Calculator";

	public TaxCalculatorFragment() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_tax_calculator,
				container, false);

		TaxResult result_plan = planToSaveTax();
		displayPlanningResult(result_plan);
		
		TaxResult result_tax = calculateTax();
		displayTaxResult(result_tax);
		
		TaxResult result_impact = calculateImpactOfIncrement();
		displayImpactResult(result_impact);
		

		return rootView;
	}
	
	private TaxResult calculateTax() {
		Double income = 2800000d;
		return TCManager.getInstance().calculateTax(income, InputType.YEARLY, TaxAPIType.SALARIED, 2014);
	}

	private void displayTaxResult(TaxResult result) {
		System.out.println("Taxable Salary Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Salary Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Take Home Salary Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Salary Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax() + "%");
	}

	private TaxResult calculateImpactOfIncrement() {
		Double income = 2600000d;
		Double increase = 200000d;
		return TCManager.getInstance().calculateImpactOfIncrement(income, increase, InputType.YEARLY, TaxAPIType.SALARIED, 2014);
	}

	private void displayImpactResult(TaxResult result) {
		System.out.println("Taxable Salary Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Salary Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Expected Taxable Salary Yearly : " + result.getExpectedTaxableIncomeYearly());
		System.out.println("Expected Taxable Salary Monthly : " + result.getExpectedTaxableIncomeMonthly());
		
		System.out.println("Increase In Taxable Salary Yearly : " + result.getIncreaseInTaxableIncomeYearly());
		System.out.println("Increase In Taxable Salary Monthly : " + result.getIncreaseInTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Total Expected Tax Payable Yearly : " + result.getExpectedTaxYearly());
		System.out.println("Total Expected Tax Payable Monthly : " + result.getExpectedTaxMonthly());
		
		System.out.println("Increase In Tax Payable Yearly : " + result.getIncreaseInTaxYearly());
		System.out.println("Increase In Tax Payable Monthly : " + result.getIncreaseInTaxMonthly());
		
		System.out.println("Take Home Salary Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Salary Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Expected Take Home Salary Yearly : " + result.getExpectedTakeHomeIncomeYearly());
		System.out.println("Expected Take Home Salary Monthly : " + result.getExpectedTakeHomeIncomeMonthly());
		
		System.out.println("Increase In Take Home Salary Yearly : " + result.getIncreaseInTakeHomeIncomeYearly());
		System.out.println("Increase In Take Home Salary Monthly : " + result.getIncreaseInTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax() + "%");
		
		System.out.println("Expected Average Rate of Tax : " + result.getExpAvgRateOfTax() + "%");
	}
	
	private TaxResult planToSaveTax() {
		Double income = 2800000d;
		Double zakat = 250000d;
		Double donation = 10000d;
		Double shares = 100000d;
		Double insurancePremium = 20000d;
		Double houseLoanInterest = 200000d;
		Double pensionFund = 100000d;
		int age = 46;
		
		return TCManager.getInstance().calculateTaxPlanning(income, zakat,
				donation, shares, insurancePremium, pensionFund, age,
				houseLoanInterest, InputType.YEARLY, TaxAPIType.SALARIED, 2014);
	}

	private void displayPlanningResult(TaxResult result) {
		System.out.println("Salary Yearly : " + result.getUiIncomeYearly());
		System.out.println("Salary Monthly : " + result.getUiIncomeMonthly());
		
		System.out.println("Taxable Salary Yearly : " + result.getTaxableIncomeYearly());
		System.out.println("Taxable Salary Monthly : " + result.getTaxableIncomeMonthly());
		
		System.out.println("Total Tax Payable Yearly : " + result.getTaxYearly());
		System.out.println("Total Tax Payable Monthly : " + result.getTaxMonthly());
		
		System.out.println("Take Home Salary Yearly : " + result.getTakeHomeIncomeYearly());
		System.out.println("Take Home Salary Monthly : " + result.getTakeHomeIncomeMonthly());
		
		System.out.println("Average Rate of Tax : " + result.getAvgRateOfTax());
		
		System.out.println("Zakat Deduction : " + result.getZakatDeduction());
		System.out.println("Donation Deduction : " + result.getDonationDeduction());
		System.out.println("Shares and Insurance Deduction : " + result.getShares_InsuranceDeduction());
		System.out.println("Pension Fund Deduction : " + result.getPensionDeduction());
		System.out.println("House Loan Interest Deduction : " + result.getHouseLoanInterestDeduction());

		System.out.println("Total Tax Saving : " + result.getTotalTaxSaving());
		System.out.println("Limited To Actual Tax Payable : " + result.getActualTaxPayable());
		System.out.println("% Tax Saving: " + result.getTaxSavingPercent() + "%");
	}
}
