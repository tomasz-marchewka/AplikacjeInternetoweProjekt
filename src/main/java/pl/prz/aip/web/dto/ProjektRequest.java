package pl.prz.aip.web.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record ProjektRequest(

		@NotBlank(message = "Tytuł projektu jest wymagany")
		String tytul,

		String opis,

		LocalDate dataRozpoczecia,

		LocalDate dataZakonczenia,

		Integer dzialId) {
}
