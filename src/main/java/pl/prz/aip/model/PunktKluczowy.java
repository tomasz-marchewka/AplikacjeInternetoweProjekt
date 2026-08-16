package pl.prz.aip.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PUNKT_KLUCZOWY")
public class PunktKluczowy extends BaseModel {

	@Column(name = "NAZWA", nullable = false)
	private String nazwa;

	@Column(name = "OPIS")
	private String opis;

	@Column(name = "DATA_UTWORZENIA")
	private LocalDate dataUtworzenia;

	@Column(name = "DATA_ZAKONCZENIA")
	private LocalDate dataZakonczenia;

	@Column(name = "PRIORYTET")
	private Integer priorytet;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJEKT")
	private Projekt projekt;
}
