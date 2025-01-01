import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ContainerModell {
	protected ArrayList<Container> ledige; 
	protected ArrayList<Oppdrag> oppdrag;
	
	public ContainerModell() {
		int[] volum = {7, 7, 9, 12, 15}; 
		double[] timepriser = {500, 550, 650, 900, 950}; 
		ledige = new ArrayList<>(); 
		for(int i=0;i<5;i++) {
			Container c = new Container(volum[i], timepriser[i]); 
			ledige.add(c); 
		}
		oppdrag = new ArrayList<>(); 
	}
	
	//kaller oppdrag for opp for å ikke forveksle med arraynavn
	public String regOppdrag(Oppdrag opp) {
		Container c = finnLedigContainer(opp); 
		if(c != null) {
			opp.setContainer(c); 
			ledige.remove(c);
			oppdrag.add(opp); 
			return "Oppdrag: " + opp.toString() + " er velykket registrert"; 
		}
		return "Fant ikke ledig container"; 
	}
	
	//hjelpemetode for å finne minste container
	public Container finnLedigContainer(Oppdrag opp) {
		if(ledige.size() != 0) { 
			Collections.sort(ledige); 
			for(Container c: ledige) {
				if(c.getVolum() >= opp.minsteVolum()) {
					return c; 
				}
			}
		}
		return null; 
	}
	
	public String avsluttOppdrag(String adresse) {
		for(Oppdrag o: oppdrag) {
			if(o.getAdresse().equals(adresse)) {
				oppdrag.remove(o); 
				ledige.add(o.getContainer()); 
				return "Fjerning av oppdrag: " + o.toString() + " er vellykket"; 
			}
		}
		return "Oppdrag for adresse: " + adresse + " har ikke blitt registrert";
	}
	

	public String nyContainer(int volum, double timepris) {
		Container c;
		try {
			c = new Container(volum, timepris); 
		} catch (Exception e){
			return "Kunne ikke registrere container: " + e.getMessage(); 
		}
		ledige.add(c); 
		return "Container: " + c.toString() + " er opprettet og ledig"; 
	}

	public ArrayList<Oppdrag> getOppdrag() {
		return oppdrag; 
	}
}