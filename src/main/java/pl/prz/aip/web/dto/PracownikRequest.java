package pl.prz.aip.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PracownikRequest(

		@NotBlank(message = "Imię jest wymagane")
		String imie,

		@NotBlank(message = "Nazwisko jest wymagane")
		String nazwisko,

		@Size(max = 11, message = "PESEL może mieć maksymalnie 11 znaków")
		String pesel,

		Integer dzialId,

		Integer projektId) {
}
