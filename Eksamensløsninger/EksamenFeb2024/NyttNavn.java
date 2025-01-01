import java.util.Date; 
public class NyttNavn extends Navn {
	//instansvariabler 
	protected Navn gammeltNavn; 
	protected Date fra; 

	//konstruktør 
	public NyttNavn(String fornavn, String mellomnavn, String etternavn, Navn gammeltNavn, Date fra) {
		super(fornavn, mellomnavn, etternavn); 
		this.gammeltNavn = gammeltNavn; 
		this.fra = fra; 
	}

	public NyttNavn(String fornavn, String etternavn, Navn gammeltNavn, Date fra) {
		this(fornavn, null, etternavn, gammeltNavn, fra); 
	}

	public NyttNavn(String navn, Navn gammeltNavn, Date fra) {
		//splitter navn ved mellomrom og lager nytt navn objekt. 
		super(navn); 
		this.gammeltNavn = gammeltNavn; 
		this.fra = fra; 
	}
}