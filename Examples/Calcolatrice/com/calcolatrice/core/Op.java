package com.calcolatrice.core;

public abstract class Op<T extends Object> {

	public T Result;
	public char[] sign;
	
	public abstract T Solve();

	
}
