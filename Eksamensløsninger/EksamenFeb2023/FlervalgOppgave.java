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

public class FlervalgOppgave extends Oppgave {
	//svaralternativer i ArrayList 
	protected ArrayList<String> alternativerTab; 

	//konstruktørmetode 
	public FlervalgOppgave(String spørsmål, double vekt, String fasit, 
							ArrayList<String> alternativerTab) {
		super(spørsmål, vekt, fasit.toUpperCase());
		setAlternativer(alternativerTab); 
		if(this.fasit.length() != 1) {
			throw new IllegalArgumentException("Gal fasit i flervalgsoppgave!"); 
		}
	}
	
	//metode som returnerer score basert på svar 
	@Override 
	public double score(String svar) {
		if(svar == null) return 0.0; 
		if(svar.length() != 1) return 0.0;
		svar = svar.toUpperCase(); 
		return ((svar.equals(fasit))? 1.0 : 0.0); 
	}
	
	//setmetode for alternativer 
	public void setAlternativer(ArrayList<String> alternativerTab) {
		this.alternativerTab = alternativerTab; 
	}
	
	//get metode for alternativer 
	public ArrayList<String> getAlternativer() {
		return alternativerTab; 
	}
	
	//get metode for antall alternativer
	public int getAntAlternativer() {
		return (alternativerTab == null) ? 0 : alternativerTab.size(); 
	}
}