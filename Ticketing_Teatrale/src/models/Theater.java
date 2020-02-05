package models;

import java.util.List;

public class Theater {
	
	public String name;
	private String ownerName;
	private List<Ticket> releasedTickets;
	private List<Show> plannedShows;
	private int ticketMatrix;
	
	public Theater(String name, String ownerName, List<Ticket> releasedTickets, List<Show> plannedShows) {
		
		this.name = name;
		this.ownerName = ownerName;
		this.releasedTickets = releasedTickets;
		this.plannedShows = plannedShows;
	}
	
	public Theater(String name, List<Ticket> releasedTickets, List<Show> plannedShows) {
		
		this.name = name;
		this.ownerName = "Unspecified";
		this.releasedTickets = releasedTickets;
		this.plannedShows = plannedShows;
	}

	public Theater(String name, String ownerName) {
		
		this.name = name;
		this.ownerName = ownerName;
	}

	public Theater(String name) {
		this.name = name;
		this.ownerName = "Unspecified";
	}
	
	private int assignID() {
		this.ticketMatrix++;
		return this.ticketMatrix-1;
	}
	
	public Ticket releaseTicket(String operator, Show showForTicket) {
		Ticket ticket = new Ticket(showForTicket, assignID() ,operator);
		this.releasedTickets.add(ticket);
		return ticket;
	}
	
	
	
	
	
	
}
