package pl.prz.aip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.prz.aip.model.Pracownik;
import pl.prz.aip.repository.DzialRepository;
import pl.prz.aip.repository.PracownikRepository;
import pl.prz.aip.repository.ProjektRepository;

@RestController
public class PracownicyController {

	@Autowired
	private PracownikRepository pracownikRepository;
	
	@Autowired
	private DzialRepository dzialRepository;
	
	@Autowired
	private ProjektRepository projektRepository;

	@RequestMapping(value = "/pracownicy", method = RequestMethod.GET)
	public Iterable<Pracownik> getAll() {
		return pracownikRepository.findAll();
	}

	@RequestMapping(value = "/pracownicy", method = RequestMethod.POST)
	public ResponseEntity<Pracownik> add(@RequestBody Pracownik input) {
		if(input.getDzialId() != null) {
			input.setDzial(dzialRepository.findOne(input.getDzialId()));
		}
		if(input.getProjektId() != null) {
			input.setProjekt(projektRepository.findOne(input.getProjektId()));
		}
		pracownikRepository.save(input);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pracownicy/{pracownikId}", method = RequestMethod.DELETE)
	public ResponseEntity<Pracownik> delete(@PathVariable Integer pracownikId) {
		pracownikRepository.delete(pracownikId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
