package pl.prz.aip.model;

import java.time.LocalDate;
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
@Table(name = "PROJEKT")
public class Projekt extends BaseModel {

	@Column(name = "TYTUL", nullable = false)
	private String tytul;

	@Column(name = "OPIS")
	private String opis;

	@Column(name = "DATA_ROZPOCZECIA")
	private LocalDate dataRozpoczecia;

	@Column(name = "DATA_ZAKONCZENIA")
	private LocalDate dataZakonczenia;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DZIAL")
	private Dzial dzial;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projekt")
	private Set<PunktKluczowy> punktyKluczowe;
}
