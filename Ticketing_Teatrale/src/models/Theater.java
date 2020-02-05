package models;

import java.util.List;

public class Theater {
	
	public String name;
	private String ownerName;
	private List<Ticket> releasedTickets;
	private List<Show> plannedShows;
	private int ticketMatrix;
	public int maxTicketsForShow;
	
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
	
	protected void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	protected void setReleasedTickets(List<Ticket> releasedTickets) {
		this.releasedTickets = releasedTickets;
	}

	protected void setPlannedShows(List<Show> plannedShows) {
		this.plannedShows = plannedShows;
	}

	protected void setTicketMatrix(int ticketMatrix) {
		this.ticketMatrix = ticketMatrix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxTicketsForShow() {
		return maxTicketsForShow;
	}

	public void setMaxTicketsForShow(int maxTicketsForShow) {
		this.maxTicketsForShow = maxTicketsForShow;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public List<Ticket> getReleasedTickets() {
		return releasedTickets;
	}

	public List<Show> getPlannedShows() {
		return plannedShows;
	}

	public int getTicketMatrix() {
		return ticketMatrix;
	}

	public Ticket releaseTicket(String operator, Show showForTicket) {
		Ticket ticket = new Ticket(showForTicket, assignID() ,operator);
		this.releasedTickets.add(ticket);
		return ticket;
	}
	
	
	
	
	
	
}
