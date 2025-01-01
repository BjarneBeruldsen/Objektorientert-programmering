import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*; 
import static java.lang.Math.*;
import java.util.*;
import java.io.*;


public abstract class Oppgave {
	//Konstanter for å sjekke lovlige verdier 
	final static int MAX_VEKT = 100; 
	final static int MIN_VEKT = 0; 

	//instansvariabler 
	protected String spørsmål; 
	protected double vekt; 
	protected String fasit; 
	protected double score = 0.0; 
	
	//konstruktørmetode 
	public Oppgave (String spørsmål, double vekt, String fasit) {
		setSpørsmål(spørsmål); 
		setVekt(vekt); 
		setFasit(fasit); 
	}
	
	//set og get metoder 
	public void setSpørsmål(String spørsmål) {
		this.spørsmål = spørsmål; 
	} 
	
	public String getSpørsmål() {
		return spørsmål; 
	} 
	
	//hjelpemetode for å sjekke om verdier er mellom to tall 
	protected boolean sjekkMellom(double tall, double max, double min) {
		return (tall >= min) && (tall <=max); 
	}
	
	public void setVekt(double v) {
		if(!sjekkMellom(v, MAX_VEKT, MIN_VEKT)) {
			throw new IllegalArgumentException("Gitt vekt: " + v + " er ikke mellom 0 og 100"); 
		}
		vekt = v; 
	}
	
	public double getVekt() {
		return vekt; 
	}
	
	public void setFasit(String fasit) {
		if(fasit == null) {
			throw new IllegalArgumentException("Fasit mangler!"); 
		}
		this.fasit = fasit; 
	}
	
	public String getFasit() {
		return fasit; 
	}
	
	//metode som returnerer score basert på svar 
	public abstract double score(String svar); 
	
	
	//metode som vekter score 
	public double vektetScore(String svar) {
		return vekt * score(svar);
	} 
}