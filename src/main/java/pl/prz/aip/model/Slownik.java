package pl.prz.aip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SLOWNIK")
public class Slownik extends BaseModel<Integer> {
	
	public static final String SLOWNIK = "slownik";
	public static final String WARTOSC = "wartosc";
	
	private String slownik;
	private String wartosc;
	
	@Column(name = "SLOWNIK")
	public String getSlownik() {
		return slownik;
	}
	public void setSlownik(String slownik) {
		this.slownik = slownik;
	}
	
	@Column(name = "WARTOSC")
	public String getWartosc() {
		return wartosc;
	}
	public void setWartosc(String wartosc) {
		this.wartosc = wartosc;
	}
	
	

	
}
