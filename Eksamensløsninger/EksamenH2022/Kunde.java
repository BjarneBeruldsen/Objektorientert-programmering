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

public class Kunde {

	protected String regNr; 
	
	public Kunde(String regNr) {
		setRegNr(regNr); 
	}

	@Override
    public boolean equals(Object o){
        if (! (o instanceof Kunde)) return false;
        Kunde k = (Kunde) o;
        return regNr.equals(k.regNr);
    }
	
	//set og get metoder 
	public void setRegNr(String regNr) {
		this.regNr = regNr; 
	}
	
	public String getRegNr() {
		return regNr; 
	}
	
	//metode for pris pr min 
	public int minuttPris() {
		return Parkeringshus.PRIS; 
	}
	
	//toString metode 
	@Override
	public String toString() {
		return "RegNr:"+regNr;  
	}
}