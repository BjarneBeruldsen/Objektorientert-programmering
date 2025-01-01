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

public class NyFlervalgOppgave extends FlervalgOppgave {
	//konstruktørmetode 
	public NyFlervalgOppgave(String spørsmål, double vekt, String fasit, 
											ArrayList<String> alternativerTab) {
		super(spørsmål, vekt, fasit, alternativerTab);
	}
	
	//overrider score metode 
	@Override
	public double score(String svar) {
		if(svar == null) return 0.0; 
		svar = svar.toUpperCase(); 
		
		//sjekker for duplikater 
		if(duplikat(svar)) throw new 
			IllegalArgumentException("Duplikat i svaralternativer!"); 

		int antAlt = alternativerTab.size(); 
		int antSvar = svar.length(); 
		double score = 0.0; 
		for(int i=0;i<antSvar;i++) {
			char b = svar.charAt(i); 
			score += (fasit.charAt(0) == b) ? 1.0 : -1.0/(antAlt - 1); 
		}
		return score; 
	}

	private boolean duplikat(String s) {
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i) == s.charAt(j)) {
					return true; 
				}
			}
		}
		return false; 
	}
}