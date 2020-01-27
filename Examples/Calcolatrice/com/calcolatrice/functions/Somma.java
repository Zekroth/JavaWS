package com.calcolatrice.functions;

import com.calcolatrice.core.BinaryOp;

public class Somma extends BinaryOp<Double,Double,Double> {

	
	@Override
	public Double Solve() {
		// TODO Auto-generated method stub
		
		return (Double) Result;
	}

	@Override
	public Double Solve(Double value1, Double value2) {

		Result = value1 + value2;
		return (Double) Result;
	}

}
