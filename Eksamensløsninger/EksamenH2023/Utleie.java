public class Utleie implements Comparable<Utleie>{
	//instansvariabler 
	protected UtleieObjekt utleieObjekt; 
	protected Kunde kunde;  
	protected Dato startDato; 
	protected Dato sluttDato; 
	
	//konstruktømetode med sluttdato 
	public Utleie(UtleieObjekt utleieObjekt, Kunde kunde, Dato startDato, Dato sluttDato) {
		setUtleieObjekt(utleieObjekt); 
		setKunde(kunde); 
		setStartDato(startDato); 
		if(sluttDato != null) {
			setSluttDato(sluttDato);
		}
	}

	//konstruktørmetode uten sluttdato
	public Utleie(UtleieObjekt utleieObjekt, Kunde kunde, Dato startDato) {
		this(utleieObjekt, kunde, startDato, null); 
	}

	//setmetoder for alle instansvariabler 
	public void setUtleieObjekt(UtleieObjekt utleieObjekt) {
		this.utleieObjekt = utleieObjekt; 
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde; 
	}	

	//dato set metoder som sjekker at startdato er før sluttdato
	public void setStartDato(Dato startDato) {
		if(sluttDato != null && sluttDato.compareTo(startDato) < 0) {
			throw new IllegalArgumentException("sluttdato: " + sluttDato + 
												" kan ikke være før startdato: " + startDato); 
		}
		else {
			this.startDato = startDato; 
		}
	}

	public void setSluttDato(Dato sluttDato) {
		if(startDato != null && sluttDato.compareTo(startDato) < 0) {
			throw new IllegalArgumentException("sluttdato: " + sluttDato + 
												" kan ikke være før startdato: " + startDato); 
		}
		else {
			this.sluttDato = sluttDato; 
		}
	}


	//toString metode 
	public String toString() {
		return "Utleieobjekt: " + utleieObjekt + '\n' + 
			   "Kunde: " + kunde + '\n' + 
				"Startdato: " + startDato + " - Sluttdato: " + sluttDato; 
	}


	//objekter av Utleie skal kunne sorteres på startdato 
	public int compareTo(Utleie u) {
		return startDato.compareTo(u.startDato); 
	}
}
	