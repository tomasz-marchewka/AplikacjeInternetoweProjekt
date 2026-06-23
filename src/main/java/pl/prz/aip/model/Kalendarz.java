package pl.prz.aip.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "KALENDARZ")
public class Kalendarz extends BaseModel<Integer> {
	
	public static final String DATA = "data";
	public static final String PRACOWNIK = "pracownik";
	public static final String TYP = "typ";

	private Date data;
	private Pracownik pracownik;
	private Slownik typ;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRACOWNIK")
	public Pracownik getPracownik() {
		return pracownik;
	}
	public void setPracownik(Pracownik pracownik) {
		this.pracownik = pracownik;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYP")
	public Slownik getTyp() {
		return typ;
	}
	public void setTyp(Slownik typ) {
		this.typ = typ;
	}
	
	
	
}
