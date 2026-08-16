package pl.prz.aip.web.dto;

import java.time.LocalDate;

import pl.prz.aip.model.Projekt;

public record ProjektResponse(
		Integer id,
		String tytul,
		String opis,
		LocalDate dataRozpoczecia,
		LocalDate dataZakonczenia,
		DzialResponse dzial) {

	public static ProjektResponse from(Projekt projekt) {
		if (projekt == null) {
			return null;
		}
		return new ProjektResponse(
				projekt.getId(),
				projekt.getTytul(),
				projekt.getOpis(),
				projekt.getDataRozpoczecia(),
				projekt.getDataZakonczenia(),
				DzialResponse.from(projekt.getDzial()));
	}
}
