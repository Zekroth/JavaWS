package com.calcolatrice.core;

public class Number extends Op<Double> {
	
	public Number(int numberEndIndex) {
		this.Result = (double) numberEndIndex;
	}
	
	public Number(double numberEndIndex) {
		this.Result = (Double) numberEndIndex;
	}
	
	public void Assign(Double d) {
		
		this.Result = d;
		
		return;
	}
	
	@Override
	public Double Solve() {
		// TODO Auto-generated method stub
		return Result;
	}

}
