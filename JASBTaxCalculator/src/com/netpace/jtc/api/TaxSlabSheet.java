package com.netpace.jtc.api;

import java.util.ArrayList;
import java.util.List;
import com.netpace.jtc.util.Util;

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
		
		sheet.setSlabs( Util.getSlabsFromCSV(fileName) );
		
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
