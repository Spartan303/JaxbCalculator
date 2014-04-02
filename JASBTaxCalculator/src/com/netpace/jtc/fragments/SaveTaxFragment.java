package com.netpace.jtc.fragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.netpace.jtc.R;
import com.netpace.jtc.adapters.SaveTaxExpandableListAdapter;

public class SaveTaxFragment extends Fragment {
	
	
	ExpandableListView expListView;
	SaveTaxExpandableListAdapter listAdapter;
	List<String> saveTaxHeaderArray;
	List<String> saveTaxContentArray;
	
	
	public SaveTaxFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		String _sampleStr = "I have tried very hard to find the process to get the cocos2d-x project work with Android. I finally succeeded"
				+ " and want you to easily install it without any trouble. Please refer to the below tutorials and let me know in case "
				+ "of any issues. I am as well new to this but I will try my best.";
		
        View rootView = inflater.inflate(R.layout.fragment_save_tax, container, false);
        expListView = (ExpandableListView) rootView.findViewById(R.id.saveTaxLVExp);
        
        saveTaxHeaderArray = Arrays.asList(getResources().getStringArray(R.array.save_tax_array));
        saveTaxContentArray = new ArrayList<String>();
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        saveTaxContentArray.add(_sampleStr);
        
        
        listAdapter = new SaveTaxExpandableListAdapter(getActivity().getApplicationContext(), saveTaxHeaderArray, saveTaxContentArray);
        expListView.setAdapter(listAdapter);
        return rootView;
    }
}
