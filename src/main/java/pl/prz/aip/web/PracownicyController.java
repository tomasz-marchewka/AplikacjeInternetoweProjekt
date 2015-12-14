package pl.prz.aip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.prz.aip.model.Pracownik;
import pl.prz.aip.repository.DzialRepository;
import pl.prz.aip.repository.PracownikRepository;

@RestController
public class PracownicyController {

	@Autowired
	private PracownikRepository pracownikRepository;
	
	@Autowired
	private DzialRepository dzialRepository;

	@RequestMapping(value = "/pracownicy", method = RequestMethod.GET)
	public Iterable<Pracownik> getAll() {
		return pracownikRepository.findAll();
	}

	@RequestMapping(value = "/pracownicy", method = RequestMethod.POST)
	public ResponseEntity<Pracownik> add(@RequestBody Pracownik input) {
		if(input.getDzialId() != null) {
			input.setDzial(dzialRepository.findOne(input.getDzialId()));
		}
		pracownikRepository.save(input);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
