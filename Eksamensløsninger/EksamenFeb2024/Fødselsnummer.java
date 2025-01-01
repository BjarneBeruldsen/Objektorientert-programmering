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


public class Fødselsnummer {
	protected String fnr; 
	//tabell for dager i måned 
	final static int[] dager = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 

	public Fødselsnummer(String fnr) { 
		if(fnr.length() != 11) {
			throw new IllegalArgumentException("Ulovlig lengde fødselsnummer: " + fnr);
		} else if(!fnr.matches("\\d+")){
		 	throw new IllegalArgumentException("Fødselsnummer kan kun inneholde tall fnr: " + fnr); 
		}
		this.fnr = fnr; 
		int mnd = måned(); 
		if(mnd< 1 || mnd > 12) {
			throw new IllegalArgumentException("Måned i fnr: " + fnr + " eksisterer ikke"); 
		}
		int dato = dato(); 
		if(dato < 1 || dato > dager[mnd]) {
			throw new IllegalArgumentException("Dag i fnr: " + fnr + " eksisterer ikke for gitt måned"); 
		}
	}



	//metode for å hente dato 
	public int dato() {
		return Integer.parseInt(fnr.substring(0,2));
	}

	//metod for å hente måned 
	public int måned() {
		return Integer.parseInt(fnr.substring(2,4));
	}


	//metode for å hente år 
	public int år() {
		int år = parseInt(fnr.substring(4, 6)); 
		GregorianCalendar gc = new GregorianCalendar();
		int århundre = gc.get(Calendar.YEAR) / 100;  
		if(år > gc.get(Calendar.YEAR)%100) {
			år += (århundre-1) * 100; 
		}
		else {
			år += (århundre-1) * 100;  
		}
		return år; 
	}

	//metode for å hente fødselsdato
	public GregorianCalendar fødselsdato() {
		int år = år(); 
		int mnd = måned();
		int dag = dato(); 
		return new GregorianCalendar(år, mnd, dag) ;
	}

	//metode for å sjekke om kjønn=mann 
	public boolean mann() {
		int nr = parseInt(fnr.substring(8, 9)); 
		return nr % 2 > 0; 
	}

	//metode for å sjekke om kjønn=kvinne 
	public boolean kvinne() {
		int nr = parseInt(fnr.substring(8, 9)); 
		return nr % 2 == 0; 
	}

	//toString metode 
	public String toString() {
		return fnr; 
	}
}