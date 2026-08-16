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
@Table(name = "KALENDARZ")
public class Kalendarz extends BaseModel {

	@Column(name = "DATA", nullable = false)
	private LocalDate data;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRACOWNIK")
	private Pracownik pracownik;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYP")
	private Slownik typ;
}
