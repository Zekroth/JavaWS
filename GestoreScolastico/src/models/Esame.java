package models;

import java.util.Date;
import java.util.List;

public class Esame {
	
	//FIELDS
	private Date date;
	private List<Professore> professor;
	private Corso course;
	private List<Studente> student;
	
	private String nomeEsame;
	private int codiceEsame;
	
	//GLOBALS
	private static int maxCodiceEsame;
	
	
	
}
