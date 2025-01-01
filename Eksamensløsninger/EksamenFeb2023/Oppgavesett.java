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


public class Oppgavesett {
	private ArrayList<Oppgave> oppgaverTab; 
	private double sumVekt = 0.0; 
	
	public Oppgavesett() {
		oppgaverTab = new ArrayList<>(); 
	}
	
	
	public void addOppgave(Oppgave oppg) {
			oppgaverTab.add(oppg);
			sumVekt += oppg.getVekt();  
	}
	
	public Oppgave getOppgave(int oppgNr) {
		if(oppgNr >= oppgaverTab.size() || oppgNr < 0) {
			throw new IllegalArgumentException("Oppgnr: " + oppgNr + " eksiterer ikke!");
		}
		return oppgaverTab.get(oppgNr); 
	}
	
	public int getAntallOppgaver() {
		return oppgaverTab.size(); 
	}
	
	public double rette(ArrayList<String> svarTab) {
		if(svarTab.size() != oppgaverTab.size()) {
			throw new IllegalArgumentException("Ant. oppgaver " + oppgaverTab.size() +
												" samsvarer ikke med ant. svar: " 
												+ svarTab.size());
		}
		if(svarTab == null) return 0.0; 
		
		double poengsum = 0.0; 
		for(int i=0;i<svarTab.size();i++) {
			poengsum += oppgaverTab.get(i).vektetScore(svarTab.get(i)); 
		}
		return poengsum / sumVekt * 100; 
	}
}