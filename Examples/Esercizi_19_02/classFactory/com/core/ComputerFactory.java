package classFactory.com.core;
import java.lang.reflect.InvocationTargetException;

import com.examples.Server;

import classFactory.com.models.Computer;

public interface ComputerFactory<T extends Computer> {
	
	@SuppressWarnings("deprecation")
	public static <T extends Computer> T generate(Class<T> type, Object[] params) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		T obj = type.getDeclaredConstructor().newInstance(params);
		if(obj instanceof Computer) {
			return obj;
		}else {
			throw new InstantiationException("The type is not a Computer subclass");
		}
	}

	public static <T> T generate(Class<T> type) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		T obj = type.getDeclaredConstructor().newInstance();
		if(obj instanceof Computer) {
			return obj;
		}else {
			throw new InstantiationException("The type is not a Computer subclass");
		}
	}
	
}
