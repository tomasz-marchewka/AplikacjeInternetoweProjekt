package pl.prz.aip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "STANOWISKO")
public class Stanowisko extends BaseModel {

	@Column(name = "NAZWA", nullable = false)
	private String nazwa;
}
