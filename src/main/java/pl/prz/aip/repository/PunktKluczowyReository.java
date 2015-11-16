package pl.prz.aip.repository;

import org.springframework.data.repository.CrudRepository;

import pl.prz.aip.model.PunktKluczowy;

public interface PunktKluczowyReository extends
		CrudRepository<PunktKluczowy, Integer> {

}
