package com.interfaces.console;

import java.util.ArrayList;
import java.util.List;
import java.beans.Expression;
import java.lang.reflect.Method;

import com.examples.LazySingleton;

public class SingletonWrapper {

	public static void main(String[] args) throws Exception {
		
		LazySingleton ls = LazySingleton.getInstance(Thread.currentThread().getName());
		System.out.println(ls.nome);
		Method met = null;
		ArrayList<Method> l = new ArrayList<Method>();
		for(Method m : LazySingleton.class.getMethods()) {
			l.add(m);
			if(m.getName().equals("getInstance")){
				met = m;
				break;
			}
		}
		
		if(met == (null)) {
			throw new Exception();
		}
		
		met.invoke(LazySingleton.class, new Object[0]);
		
		
	}

}
