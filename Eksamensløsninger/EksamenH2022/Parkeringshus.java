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

public class Parkeringshus {
	protected int antParkPlass; 
	protected ArrayList<Parkering> aktivParkering; 
	protected ArrayList<Parkering> tidligereParkering; 
	protected ArrayList<RegistrertKunde> kunderTab; 
	static int PRIS; 
	
	public Parkeringshus(int antParkPlass, int pris) {
		if(antParkPlass < 2) throw new IllegalArgumentException("Antall plasser: " + 
																		antParkPlass); 
		this.antParkPlass = antParkPlass; 
		PRIS = pris; 
		aktivParkering = new ArrayList<>(); 
		tidligereParkering = new ArrayList<>(); 
		kunderTab = new ArrayList<>(); 
	}
	
	//metode inn 
	public void inn(String regNr, Date tidspunkt) {
		Kunde kunde = finnKunde(regNr); 
		if(kunde == null) kunde = new TilfeldigKunde(regNr); 
		Parkering parkering = new Parkering(kunde, tidspunkt); 
		aktivParkering.add(parkering); 
	}
	
	//metode ut 
	public void ut(String regNr, Date tidspunkt) {
		Parkering parkering = slettParkering(regNr); 
		if(parkering == null) {
			throw new IllegalArgumentException("Bil har ikke blitt registrert inn: " + regNr);
		}
		parkering.setUtkjøring(tidspunkt); 
		parkering.fakturer(); 
		tidligereParkering.add(parkering); 
		
	}

	public Kunde finnKunde(String regNr) {
		for(RegistrertKunde k: kunderTab) {
			if(k.getRegNr().equals(regNr)) {
				return k; 
			}
		}
		return null; 
	}

	public Parkering slettParkering(String regNr) {
		Iterator<Parkering> parkeringIt = aktivParkering.iterator(); 
		while(parkeringIt.hasNext()) {
			Parkering p = parkeringIt.next(); 
			if(p.getKunde().getRegNr().equals(regNr)) {
				parkeringIt.remove(); 
				return p; 
			}
		}
		return null; 
	}
	
	public int getAntPlasser() {
		return antParkPlass; 
	}
	public int getAntOpptattPlasser() {
		return aktivParkering.size(); 
	}
	public int getAntLedigPlasser() {
		return antParkPlass - aktivParkering.size(); 
	}
	
	public ArrayList<RegistrertKunde> getKunderTab() {
		return kunderTab; 
	}
	
	public void regKunde(RegistrertKunde k) {
		kunderTab.add(k); 
	}
}