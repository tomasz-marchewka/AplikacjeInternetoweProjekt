package pl.prz.aip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.prz.aip.model.Dzial;
import pl.prz.aip.repository.DzialRepository;

@RestController
public class DzialController {

	@Autowired
	private DzialRepository dzialRepository;

	@RequestMapping(value = "/dzialy", method = RequestMethod.GET)
	public Iterable<Dzial> getAll() {
		return dzialRepository.findAll();
	}
}
