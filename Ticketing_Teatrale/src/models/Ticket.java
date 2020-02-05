package models;

import java.util.Calendar;
import java.util.Date;

public class Ticket {
	
	private Show show;
	private int ticketID;
	private boolean used;
	public Date releaseDate;
	public String assistantName;
	
	public Ticket(Show show, int id, Date releaseDate, String assistantName) {
		
		this.show = show;
		this.ticketID = id;
		this.releaseDate = releaseDate;
		this.assistantName = assistantName;
		this.used = false;
		
	}
	
	public Ticket(Show show, int id, String assistantName) {
		
		this.show = show;
		this.ticketID = id;
		this.releaseDate = Calendar.getInstance().getTime();
		this.assistantName = assistantName;
		this.used = false;
		
	}
	
	public Ticket(Show show, int id, String assistantName, boolean used) {
		
		this.show = show;
		this.ticketID = id;
		this.releaseDate = Calendar.getInstance().getTime();
		this.assistantName = assistantName;
		this.used = used;
		
	}
	
	public Ticket(Show show, int id, boolean used, Date releaseDate, String assistantName) {
		
		this.show = show;
		this.ticketID = id;
		this.used = used;
		this.releaseDate = releaseDate;
		this.assistantName = assistantName;
		
	}

	
	public Show getShow() {
		return show;
	}

	protected void setShow(Show show) {
		this.show = show;
	}

	public int getTicketID() {
		return ticketID;
	}

	protected void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public boolean isUsed() {
		return used;
	}

	protected void setUsed(boolean used) {
		this.used = used;
	}
	
	
	
}
