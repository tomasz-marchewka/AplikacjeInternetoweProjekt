package pl.prz.aip.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRACOWNIK")
public class Pracownik extends BaseModel {

	@Column(name = "IMIE", nullable = false)
	private String imie;

	@Column(name = "NAZWISKO", nullable = false)
	private String nazwisko;

	@Column(name = "PESEL")
	private String pesel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DZIAL")
	private Dzial dzial;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STANOWISKO")
	private Stanowisko stanowisko;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJEKT")
	private Projekt projekt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pracownik")
	private Set<Ewidencja> ewidencje;
}
