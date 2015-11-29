package pl.prz.aip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.prz.aip.model.Pracownik;
import pl.prz.aip.repository.PracownikRepository;

@RestController
public class PracownicyController {

	@Autowired
	private PracownikRepository pracownikRepository;

	// @CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/pracownicy", method = RequestMethod.GET)
	public Iterable<Pracownik> getAll() {
		return pracownikRepository.findAll();
	}

}
