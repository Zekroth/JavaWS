package classFactory.com.models;

import java.util.Calendar;
import java.util.Date;

public abstract class Computer {
	public String nome = Calendar.getInstance().getTime().toLocaleString();
}
