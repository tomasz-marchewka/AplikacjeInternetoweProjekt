package pl.prz.aip.web.dto;

import pl.prz.aip.model.Pracownik;

public record PracownikResponse(
		Integer id,
		String imie,
		String nazwisko,
		String pesel,
		DzialResponse dzial,
		ProjektResponse projekt) {

	public static PracownikResponse from(Pracownik pracownik) {
		if (pracownik == null) {
			return null;
		}
		return new PracownikResponse(
				pracownik.getId(),
				pracownik.getImie(),
				pracownik.getNazwisko(),
				pracownik.getPesel(),
				DzialResponse.from(pracownik.getDzial()),
				ProjektResponse.from(pracownik.getProjekt()));
	}
}
