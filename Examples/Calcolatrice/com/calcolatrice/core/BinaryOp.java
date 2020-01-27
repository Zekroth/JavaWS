package com.calcolatrice.core;

public abstract class BinaryOp<T ,Tt extends Object,Ttt extends Object> extends Op{
	
	public Tt value1;
	public Ttt value2;
	
	public abstract T Solve(Tt value1, Ttt value2 );

	
	
}

