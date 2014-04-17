package com.netpace.jtc.api;

public class Slab {
	private Double startValue;
	private Double endValue;
	private Double offsetValue; // amount you should be paying at least if income is located in this slab 
	private float percentValue;	// r% of the amount exceeding startValue

	public Slab() {  }
	
	public Slab(Double startValue, Double endValue, Double offsetValue,
			float percentValue) {
		this.startValue = startValue;
		this.endValue = endValue;
		this.offsetValue = offsetValue;
		this.percentValue = percentValue;
	}

	public Double getStartValue() {
		return startValue;
	}

	public Double getEndValue() {
		return endValue;
	}

	public Double getOffsetValue() {
		return offsetValue;
	}

	public float getPercentValue(){ 
		return percentValue/100F;
	}
	
	public void setStartValue(Double startValue) {
		this.startValue = startValue;
	}

	public void setEndValue(Double endValue) {
		this.endValue = endValue;
	}

	public void setOffsetValue(Double offsetValue) {
		this.offsetValue = offsetValue;
	}

	public void setPercentValue(float percentValue) {
		this.percentValue = percentValue;
	}
}
