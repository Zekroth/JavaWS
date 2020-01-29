package com.calcolatrice.interfaces.console;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import com.calcolatrice.functions.FunctionBinder;

public class Setup {

	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		FunctionBinder fb = new FunctionBinder();
	}

}
