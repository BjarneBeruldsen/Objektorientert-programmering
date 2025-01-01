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

public class RegistrertKunde extends Kunde{
	protected String navn; 
	protected String adresse; 
	//rabatt er foreløpig 15% 
	final static double RABATT = 15; 
	
	public RegistrertKunde(String regNr, String navn, String adresse) {
		super(regNr);
		setNavn(navn); 
		setAdresse(adresse); 
	}
	
	public void setNavn(String navn) {
		this.navn = navn; 
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse; 
	}
	
	public String getNavn() {
		return navn; 
	}
	
	public String getAdresse() {
		return adresse; 
	}
	
	@Override
	public int minuttPris() {
		return (int)(super.minuttPris() * (1 - RABATT/100 )); 
	}
	
	@Override 
	//toString metode 
	public String toString() {
		return super.toString() + " " + navn + " " + adresse;  
	}
}