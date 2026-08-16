package pl.prz.aip.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EWIDENCJA")
public class Ewidencja extends BaseModel {

	@Column(name = "DATA_WEJSCIA")
	private LocalDate dataWejscia;

	@Column(name = "DATA_WYJSCIA")
	private LocalDate dataWyjscia;

	@ManyToOne
	@JoinColumn(name = "PRACOWNIK")
	private Pracownik pracownik;
}
