package pl.prz.aip.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "PRACOWNIK")
public class Pracownik extends BaseModel<Integer> {

	
	public static final String IMIE = "imie";
	public static final String NAZWISKO = "nazwisko";
	public static final String PESEL = "pesel";
	public static final String DZIAL = "dzial";
	public static final String STANOWISKO = "stanowisko";
	public static final String EWIDENCJE = "ewidencje";
	
	private String imie;
	private String nazwisko;
	private String pesel;
	private Dzial dzial;
	private Stanowisko stanowisko;
	private Set<Ewidencja> ewidencje;
	
	@JsonProperty(value = "dzialId")
	private Integer dzialId;
	
	@Column(name = "IMIE")
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	@Column(name = "NAZWISKO")
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	@Column(name = "PESEL")
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DZIAL")
	public Dzial getDzial() {
		return dzial;
	}
	public void setDzial(Dzial dzial) {
		this.dzial = dzial;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STANOWISKO")
	public Stanowisko getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(Stanowisko stanowisko) {
		this.stanowisko = stanowisko;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = Ewidencja.PRACOWNIK)
	public Set<Ewidencja> getEwidencje() {
		return ewidencje;
	}
	public void setEwidencje(Set<Ewidencja> ewidencje) {
		this.ewidencje = ewidencje;
	}
	
	@Transient
	public Integer getDzialId() {
		if(dzialId == null && dzial != null) {
			return dzial.getId();
		}
		return dzialId;
	}
	public void setDzialId(Integer dzialId) {
		this.dzialId = dzialId;
	}
	
	
	
	
	
	
	
	
}
