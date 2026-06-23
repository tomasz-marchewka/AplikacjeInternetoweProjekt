package pl.prz.aip.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * Wspólna baza dla encji: klucz główny generowany przez bazę oraz pole
 * wersji wykorzystywane przez mechanizm optymistycznego blokowania.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Version
	@Column(name = "VERSION")
	private int version;
}
