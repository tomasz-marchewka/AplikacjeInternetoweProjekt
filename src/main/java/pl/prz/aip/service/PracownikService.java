package pl.prz.aip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.prz.aip.exception.ResourceNotFoundException;
import pl.prz.aip.model.Dzial;
import pl.prz.aip.model.Pracownik;
import pl.prz.aip.model.Projekt;
import pl.prz.aip.repository.DzialRepository;
import pl.prz.aip.repository.PracownikRepository;
import pl.prz.aip.repository.ProjektRepository;
import pl.prz.aip.web.dto.PracownikRequest;
import pl.prz.aip.web.dto.PracownikResponse;

@Service
@Transactional(readOnly = true)
public class PracownikService {

	private final PracownikRepository pracownikRepository;
	private final DzialRepository dzialRepository;
	private final ProjektRepository projektRepository;

	public PracownikService(PracownikRepository pracownikRepository,
			DzialRepository dzialRepository,
			ProjektRepository projektRepository) {
		this.pracownikRepository = pracownikRepository;
		this.dzialRepository = dzialRepository;
		this.projektRepository = projektRepository;
	}

	public List<PracownikResponse> findAll() {
		return pracownikRepository.findAll().stream()
				.map(PracownikResponse::from)
				.toList();
	}

	@Transactional
	public PracownikResponse create(PracownikRequest request) {
		Pracownik pracownik = new Pracownik();
		pracownik.setImie(request.imie());
		pracownik.setNazwisko(request.nazwisko());
		pracownik.setPesel(request.pesel());
		if (request.dzialId() != null) {
			pracownik.setDzial(findDzial(request.dzialId()));
		}
		if (request.projektId() != null) {
			pracownik.setProjekt(findProjekt(request.projektId()));
		}
		return PracownikResponse.from(pracownikRepository.save(pracownik));
	}

	@Transactional
	public void delete(Integer id) {
		if (!pracownikRepository.existsById(id)) {
			throw new ResourceNotFoundException("Pracownik o id %d nie istnieje".formatted(id));
		}
		pracownikRepository.deleteById(id);
	}

	private Dzial findDzial(Integer dzialId) {
		return dzialRepository.findById(dzialId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Dział o id %d nie istnieje".formatted(dzialId)));
	}

	private Projekt findProjekt(Integer projektId) {
		return projektRepository.findById(projektId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Projekt o id %d nie istnieje".formatted(projektId)));
	}
}
