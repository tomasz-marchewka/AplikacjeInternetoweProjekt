package pl.prz.aip.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PUNKT_KLUCZOWY")
public class PunktKluczowy extends BaseModel<Integer> {
	
	public static final String PRIORYTET = "priorytet";
	public static final String DATA_ZAKONCZENIA = "dataZakonczenia";
	public static final String DATA_UTWORZENIA = "dataUtworzenia";
	public static final String OPIS = "opis";
	public static final String NAZWA = "nazwa";
	public static final String PROJEKT = "projekt";

	private Integer priorytet;
	private Date dataZakonczenia;
	private Date dataUtworzenia;
	private String opis;
	private String nazwa;
	private Projekt projekt;
	
	@Column(name = "PRIORYTET")
	public Integer getPriorytet() {
		return priorytet;
	}
	public void setPriorytet(Integer priorytet) {
		this.priorytet = priorytet;
	}
	@Column(name = "DATA_ZAKONCZENIA")
	public Date getDataZakonczenia() {
		return dataZakonczenia;
	}
	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}
	@Column(name = "DATA_UTWORZENIA")
	public Date getDataUtworzenia() {
		return dataUtworzenia;
	}
	public void setDataUtworzenia(Date dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}
	@Column(name = "OPIS")
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	@Column(name = "NAZWA")
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJEKT")
	public Projekt getProjekt() {
		return projekt;
	}
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	
	
	
	
}
