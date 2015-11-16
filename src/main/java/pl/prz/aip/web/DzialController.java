package pl.prz.aip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.prz.aip.dao.DzialRepository;
import pl.prz.aip.model.Dzial;

@RestController
public class DzialController {

	@Autowired
	private DzialRepository dzialRepository;

	@RequestMapping(value = "/dzialy", method = RequestMethod.GET)
	public Iterable<Dzial> getAll() {
		return dzialRepository.findAll();
	}

	@RequestMapping(value = "/dzialy/{dzialId}", method = RequestMethod.GET)
	public Dzial getById(@PathVariable Integer dzialId) {
		return dzialRepository.findOne(dzialId);
	}

}
