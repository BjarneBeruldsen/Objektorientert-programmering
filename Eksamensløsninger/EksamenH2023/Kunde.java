public class Kunde {
	protected String navn; 
	protected String tlf; 


	public Kunde(String navn, String tlf) {
		setNavn(navn); 
		setTlf(tlf); 
	}

	public void setNavn(String navn) { this.navn = navn; }

	public String getNavn() { return navn; }

	public String getTlf() { return tlf; }

	public void setTlf(String tlf) {
		//sjekker om tlf har 8 siffer eller +47 ettefulgt av 8 siffer  
		if(tlf.matches("\\d{8}") || (tlf.matches("\\+47 \\d{8}"))) {
			this.tlf = tlf;
		}
		else {
			throw new IllegalArgumentException("Telefonnr: " + tlf + " er ikke lovlig");
		}
	}

	@Override
	public boolean equals(Object o) {
		if(! (o instanceof Kunde)) {
			return false; 
		}
		//sjekker kunde 
		return tlf.equals(((Kunde)o).tlf);
	}

	@Override
	public String toString() {
		return "Navn: " + navn + " TlfNr: " + tlf;  
	}
}