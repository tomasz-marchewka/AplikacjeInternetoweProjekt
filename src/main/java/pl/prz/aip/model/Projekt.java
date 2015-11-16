package pl.prz.aip.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROJEKT")
public class Projekt extends BaseModel<Integer> {
	
	public static final String DATA_ZAKNCZENIA  = "dataZakonczenia";
	public static final String DATA_ROZPOCZECIA = "dataRozpoczecia";
	public static final String OPIS = "opis";
	public static final String TYTUL = "tytul";
	public static final String DZIAL = "dzial";
	public static final String PUNKTY_KLUCZOWE = "punktyKluczowe";
	
	private Date dataZakonczenia;
	private Date dataRozpoczecia;
	private String opis;
	private String tytul;
	private Dzial dzial;
	private Set<PunktKluczowy> punktyKluczowe;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ZAKONCZENIA")
	public Date getDataZakonczenia() {
		return dataZakonczenia;
	}
	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ROZPOCZECIA")
	public Date getDataRozpoczecia() {
		return dataRozpoczecia;
	}
	public void setDataRozpoczecia(Date dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}
	@Column(name = "OPIS")
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	@Column(name = "TYTUL")
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	@ManyToOne
	@JoinColumn(name = "DZIAL")
	public Dzial getDzial() {
		return dzial;
	}
	public void setDzial(Dzial dzial) {
		this.dzial = dzial;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = PunktKluczowy.PROJEKT)
	public Set<PunktKluczowy> getPunktyKluczowe() {
		return punktyKluczowe;
	}
	public void setPunktyKluczowe(Set<PunktKluczowy> punktyKluczowe) {
		this.punktyKluczowe = punktyKluczowe;
	}
	
	
	

}
