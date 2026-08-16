package pl.prz.aip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.prz.aip.exception.ResourceNotFoundException;
import pl.prz.aip.model.Dzial;
import pl.prz.aip.model.Projekt;
import pl.prz.aip.repository.DzialRepository;
import pl.prz.aip.repository.ProjektRepository;
import pl.prz.aip.web.dto.ProjektRequest;
import pl.prz.aip.web.dto.ProjektResponse;

@Service
@Transactional(readOnly = true)
public class ProjektService {

	private final ProjektRepository projektRepository;
	private final DzialRepository dzialRepository;

	public ProjektService(ProjektRepository projektRepository, DzialRepository dzialRepository) {
		this.projektRepository = projektRepository;
		this.dzialRepository = dzialRepository;
	}

	public List<ProjektResponse> findAll() {
		return projektRepository.findAll().stream()
				.map(ProjektResponse::from)
				.toList();
	}

	public ProjektResponse findById(Integer id) {
		return ProjektResponse.from(projektRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Projekt o id %d nie istnieje".formatted(id))));
	}

	@Transactional
	public ProjektResponse create(ProjektRequest request) {
		Projekt projekt = new Projekt();
		projekt.setTytul(request.tytul());
		projekt.setOpis(request.opis());
		projekt.setDataRozpoczecia(request.dataRozpoczecia());
		projekt.setDataZakonczenia(request.dataZakonczenia());
		if (request.dzialId() != null) {
			projekt.setDzial(findDzial(request.dzialId()));
		}
		return ProjektResponse.from(projektRepository.save(projekt));
	}

	@Transactional
	public void delete(Integer id) {
		if (!projektRepository.existsById(id)) {
			throw new ResourceNotFoundException("Projekt o id %d nie istnieje".formatted(id));
		}
		projektRepository.deleteById(id);
	}

	private Dzial findDzial(Integer dzialId) {
		return dzialRepository.findById(dzialId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Dział o id %d nie istnieje".formatted(dzialId)));
	}
}
