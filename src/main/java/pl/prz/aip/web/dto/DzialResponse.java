package pl.prz.aip.web.dto;

import pl.prz.aip.model.Dzial;

public record DzialResponse(Integer id, String nazwa, String opis) {

	public static DzialResponse from(Dzial dzial) {
		if (dzial == null) {
			return null;
		}
		return new DzialResponse(dzial.getId(), dzial.getNazwa(), dzial.getOpis());
	}
}
