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


public class KortsvarOppgave extends Oppgave {
	//konstruktørmetode 
	public KortsvarOppgave(String spørsmål, double vekt, String fasit) {
		super(spørsmål, vekt, fasit.toUpperCase()); 
	}
	
	//score metode 
	@Override 
	public double score(String svar) {
		//trimmer svar for å fjerne evt. mellomrom forran og bak 
		svar = svar.trim(); 
		//gjør både fasit og svar til store bokstaver, slik at de blir like 
		svar = svar.toUpperCase(); 
		return (svar.equals(fasit))? 1.0 : 0.0; 
	}

}