package classFactory.com.interfaces.console;

import java.lang.reflect.InvocationTargetException;

import classFactory.com.core.*;
import classFactory.com.models.*;
public class AppStart {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Server c = ComputerFactory.generate(Server.class);
		//String test = ComputerFactory.generate(String.class);
		System.out.println(c.nome);
	}

}
