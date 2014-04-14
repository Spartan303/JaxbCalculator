package com.netpace.jtc.api;

import java.util.ArrayList;
import java.util.List;

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

//		for {
			// csv read logic 
			// row data Slab slab = new Slab()
			// sheet.slabs.add(slab)
// 		}

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
