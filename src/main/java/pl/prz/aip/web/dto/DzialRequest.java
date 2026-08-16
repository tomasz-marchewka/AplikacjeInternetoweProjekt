package pl.prz.aip.web.dto;

import jakarta.validation.constraints.NotBlank;

public record DzialRequest(

		@NotBlank(message = "Nazwa działu jest wymagana")
		String nazwa,

		String opis) {
}
