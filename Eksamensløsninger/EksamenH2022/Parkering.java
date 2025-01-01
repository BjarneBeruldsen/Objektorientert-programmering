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

public class Parkering {
	protected Kunde kunde; 
	Date innkjøring; 
	Date utkjøring; 
	final static int GRATIS_MIN = 15; 
	final static int TUSEN = 1000; 
	
	public Parkering (Kunde kunde, Date innkjøring) {
		this.kunde = kunde;  
		this.innkjøring = innkjøring; 
	}
	
	public void setUtkjøring(Date tidspunkt) {
		utkjøring = tidspunkt; 
	}

	public Date getInnkjøring() {
		return innkjøring; 
	}

	public Date getUtkjøring() {
		return utkjøring; 
	}
	
	//fakturer 
	public void fakturer() {
		if(utkjøring == null) {
			throw new IllegalArgumentException("Utkjøring er ikke registrert!"); 
		}
		int antallMin = antMin(); 
		if(antallMin > GRATIS_MIN) {
			int beløp = (kunde.minuttPris() * antallMin+99) / 100; 
			System.out.println("Kunde: " + kunde + " faktureres kr.: " + beløp); 
		} 
		else {
			System.out.println("Kunde: " + kunde + " er innenfor gratis tid: " 
															+ GRATIS_MIN + "min"); 
		}
	}
	
	//get metode for kunde 
	public Kunde getKunde() {
		return kunde; 
	}
	
	
	//hjelpemetode for antall min 
	public int antMin() {
		int sekunder = (int)(utkjøring.getTime() - innkjøring.getTime())/TUSEN; 
		int minutter = (sekunder + 59)/60; 
		return minutter; 
	}
}