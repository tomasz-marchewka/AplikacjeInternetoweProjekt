package pl.prz.aip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.prz.aip.exception.ResourceNotFoundException;
import pl.prz.aip.model.Dzial;
import pl.prz.aip.repository.DzialRepository;
import pl.prz.aip.web.dto.DzialRequest;
import pl.prz.aip.web.dto.DzialResponse;

@Service
@Transactional(readOnly = true)
public class DzialService {

	private final DzialRepository dzialRepository;

	public DzialService(DzialRepository dzialRepository) {
		this.dzialRepository = dzialRepository;
	}

	public List<DzialResponse> findAll() {
		return dzialRepository.findAll().stream()
				.map(DzialResponse::from)
				.toList();
	}

	public DzialResponse findById(Integer id) {
		return DzialResponse.from(getOrThrow(id));
	}

	@Transactional
	public DzialResponse create(DzialRequest request) {
		Dzial dzial = new Dzial();
		dzial.setNazwa(request.nazwa());
		dzial.setOpis(request.opis());
		return DzialResponse.from(dzialRepository.save(dzial));
	}

	private Dzial getOrThrow(Integer id) {
		return dzialRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Dział o id %d nie istnieje".formatted(id)));
	}
}
