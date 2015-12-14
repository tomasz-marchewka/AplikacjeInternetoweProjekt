package pl.prz.aip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.prz.aip.model.Projekt;
import pl.prz.aip.repository.DzialRepository;
import pl.prz.aip.repository.ProjektRepository;

@RestController
public class ProjektyController {

	@Autowired
	private ProjektRepository projektRepository;

	@Autowired
	private DzialRepository dzialRepository;

	@RequestMapping(value = "/projekty", method = RequestMethod.GET)
	public Iterable<Projekt> getAll() {
		return projektRepository.findAll();
	}

	@RequestMapping(value = "/projekty/{projektId}", method = RequestMethod.GET)
	public Projekt getById(@PathVariable Integer projektId) {
		return projektRepository.findOne(projektId);
	}

	@RequestMapping(value = "/projekty/{projektId}", method = RequestMethod.DELETE)
	public ResponseEntity<Projekt> deleteElement(@PathVariable Integer projektId) {
		projektRepository.delete(projektId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/projekty", method = RequestMethod.POST)
	public ResponseEntity<Projekt> add(@RequestBody Projekt input) {
		if (input.getDzialId() != null) {
			input.setDzial(dzialRepository.findOne(input.getDzialId()));
		}
		projektRepository.save(input);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
