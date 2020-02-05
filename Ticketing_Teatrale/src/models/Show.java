package models;

import java.io.Serializable;
import java.util.Date;

public class Show {
	
	public Date date;
	public String name;
	public float price;
	public boolean running;
	
	public Show(Date date, String name, float price, boolean running) {
		this.date = date;
		this.name = name;
		this.price = price;
		this.running = running;
	}
	
	public Show(Date date, String name, float price) {
		
		this.date = date;
		this.name = name;
		this.price = price;
		this.running = false;
		
	}
	
}
