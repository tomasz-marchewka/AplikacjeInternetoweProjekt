package pl.prz.aip.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
	public static final String PROJEKT = "projekt";
	
	private String imie;
	private String nazwisko;
	private String pesel;
	private Dzial dzial;
	private Stanowisko stanowisko;
	private Set<Ewidencja> ewidencje;
	private Projekt projekt;
	
	private Integer dzialId;
	private Integer projektId;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
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
	@JsonProperty(value = "dzialId")
	public Integer getDzialId() {
		if(dzialId == null && dzial != null) {
			return dzial.getId();
		}
		return dzialId;
	}
	
	public void setDzialId(Integer dzialId) {
		this.dzialId = dzialId;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJEKT")
	public Projekt getProjekt() {
		return projekt;
	}
	
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	
	@Transient
	@JsonProperty(value = "projektId")
	public Integer getProjektId() {
		if(projektId == null && projekt != null) {
			return projekt.getId();
		}
		return projektId;
	}
	
	public void setProjektId(Integer projektId) {
		this.projektId = projektId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
