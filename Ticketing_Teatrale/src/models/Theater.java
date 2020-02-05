package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Theater {
	
	public String name;
	private String ownerName;
	private List<Ticket> releasedTickets = null;
	private List<Show> plannedShows = null;
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
	
	public Show getShow(String showName) {
		for(Show s : this.plannedShows) {
			if(s.name.equalsIgnoreCase(showName)) {
				return s;
			}
		}
		return null;
	}
	
	public List<Show> lookForShow(String showName) {
		List<Show> shows = new ArrayList<Show>();
		for(Show s : this.plannedShows) {
			if(s.name.contains(showName.toLowerCase()) || s.name.contains(showName.toUpperCase())) {
				shows.add(s);
			}
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
	}

	public List<Show> lookForShow(String showName, List<Show> shows){
		
		for(Show s : this.plannedShows) {
			if(s.name.contains(showName.toLowerCase()) || s.name.contains(showName.toUpperCase())) {
				shows.add(s);
			}
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
	}
	
	public List<Show> lookForShow(Date showDate) {
		List<Show> shows = new ArrayList<Show>();
		for(Show s : this.plannedShows) {
			if(s.date.equals(showDate)) {
				shows.add(s);
			}
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
	}
	
	public List<Show> lookForShow(Date showDate, int rangeOfDays) {
		
		ArrayList<Show> shows = new ArrayList<Show>();
		
		Date beforeLimit = (Date)showDate.clone();
		beforeLimit.setTime(beforeLimit.getTime() - rangeOfDays * TimeUnit.DAYS.toMillis(1l));
		
		Date afterLimit = (Date)showDate.clone();
		afterLimit.setTime(afterLimit.getTime() - rangeOfDays * TimeUnit.DAYS.toMillis(1l));
		
		for(Show s : this.plannedShows) {
			
			if(s.date.equals(showDate)|| (showDate.after(beforeLimit) && showDate.before(afterLimit) ) ) {
				
				shows.add(s);
				
			}
			
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
	}
	
	public List<Show> lookForShow(Date showDate, List<Show> shows){
		
		for(Show s : this.plannedShows) {
			if(s.date.equals(showDate)) {
				shows.add(s);
			}
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
	}
	
	public List<Show> lookForShow(Date showDate, int rangeOfDays, List<Show> shows){
		
		Date beforeLimit = (Date)showDate.clone();
		beforeLimit.setTime(beforeLimit.getTime() - rangeOfDays * TimeUnit.DAYS.toMillis(1l));
		
		Date afterLimit = (Date)showDate.clone();
		afterLimit.setTime(afterLimit.getTime() - rangeOfDays * TimeUnit.DAYS.toMillis(1l));
		
		for(Show s : this.plannedShows) {
			
			if(s.date.equals(showDate)|| (showDate.after(beforeLimit) && showDate.before(afterLimit) ) ) {
				
				shows.add(s);
				
			}
			
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
	}
	
	public List<Show> lookForShow(int price) {
		
		List<Show> shows = new ArrayList<Show>();
		
		for(Show s : this.plannedShows) {
			if(s.price < price) {
				shows.add(s);
			}
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
		
	}
	
	public List<Show> lookForShow(int price, List<Show> shows){
		
		for(Show s : this.plannedShows) {
			if(s.price < price) {
				shows.add(s);
			}
		}
		if(shows.isEmpty()) {
			return null;
		}else {
			return shows;
		}
	}
	
}
