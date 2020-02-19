package functions;

import core.BinaryOp;

public class Somma extends BinaryOp<Double,Double,Double> {

	char[] sign = {'+'};
	
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
