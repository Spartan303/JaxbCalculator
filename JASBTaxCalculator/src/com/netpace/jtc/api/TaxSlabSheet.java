package com.netpace.jtc.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.netpace.jtc.init.ApplicationManager;

import android.content.Context;

public class TaxSlabSheet {
	private String filename;
	private int year;
	private List<Slab> slabs;
	
	public TaxSlabSheet(String filename, int year) {
		this.filename = filename;
		this.year = year;
		slabs = new ArrayList<Slab>();
	}

	public static TaxSlabSheet load(String fileName, int year) {

		TaxSlabSheet sheet = new TaxSlabSheet(fileName, year);
		
		Context context = ApplicationManager.getAppContext();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<Slab> slabs = new ArrayList<Slab>();
		Slab slab = new Slab();
		
		try {
			br = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
			br.readLine();
			while ((line = br.readLine()) != null) {
				
				String[] bracket = line.split(cvsSplitBy);
				slab.setStartValue(Double.valueOf(bracket[0]));
				slab.setEndValue(Double.valueOf(bracket[1]));
				slab.setOffsetValue(Double.valueOf(bracket[2]));
				slab.setPercentValue(Float.valueOf(bracket[3]));
				
				slabs.add(slab);
			}
			sheet.setSlabs(slabs);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sheet;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Slab> getSlabs() {
		return slabs;
	}

	public void setSlabs(List<Slab> slabs) {
		this.slabs = slabs;
	}

}
