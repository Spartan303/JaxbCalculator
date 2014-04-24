package com.netpace.jtc.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.netpace.jtc.api.Slab;
import com.netpace.jtc.init.ApplicationManager;

public class Util {

	public static List<Slab> getSlabsFromCSV(String fileName)
	{
//		Uncomment it for android application		
		Context context = ApplicationManager.getAppContext();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<Slab> slabs = new ArrayList<Slab>();
		
		try {
			
// ==============================================================================================================================
//			Just for Console Application
//			fileName = "C:\\slabs\\" + fileName;
//			FileReader fr = new FileReader(new File(fileName));
//			br = new BufferedReader(fr);
//===============================================================================================================================

//			For Android Application
			br = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
			
			br.readLine(); // skip this line for columns heading
			while ((line = br.readLine()) != null) {
				Slab slab = new Slab();
				String[] bracket = line.split(cvsSplitBy);
				slab.setStartValue(Double.valueOf(bracket[0]));
				slab.setEndValue(Double.valueOf(bracket[1]));
				slab.setOffsetValue(Double.valueOf(bracket[2]));
				slab.setPercentValue(Float.valueOf(bracket[3]));
				
				slabs.add(slab);
			}
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
		return slabs;
	}
}
