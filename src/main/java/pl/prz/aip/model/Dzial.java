package pl.prz.aip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DZIAL")
public class Dzial extends BaseModel {

	@Column(name = "NAZWA", nullable = false)
	private String nazwa;

	@Column(name = "OPIS")
	private String opis;
}
