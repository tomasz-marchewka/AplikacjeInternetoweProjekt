package pl.prz.aip.repository;

import org.springframework.data.repository.CrudRepository;

import pl.prz.aip.model.Stanowisko;

public interface StanowiskoRepository extends
		CrudRepository<Stanowisko, Integer> {

}
