package pl.prz.aip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SLOWNIK")
public class Slownik extends BaseModel {

	@Column(name = "SLOWNIK", nullable = false)
	private String slownik;

	@Column(name = "WARTOSC", nullable = false)
	private String wartosc;
}
