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


public class JaNeiOppgave extends Oppgave{
	//konstruktørmetode 
	public JaNeiOppgave(String spørsmål, double vekt, String fasit) {
		super(spørsmål, vekt, fasit.toLowerCase());
		if(!(this.fasit.equals("true") || this.fasit.equals("false")) ) {
			throw new IllegalArgumentException("Fasit må være true eller false"); 
		} 
	}
	
	//overrider score-metoden 
	@Override 
		public double score(String svar) {
		//sjekker om fasit er true eller false i string format 
		svar = svar.toLowerCase(); 

		return svar.equals(fasit)? 1.0 : 0.0; 
	}

}