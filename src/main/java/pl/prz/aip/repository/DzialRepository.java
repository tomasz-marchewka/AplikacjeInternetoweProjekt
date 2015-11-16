package pl.prz.aip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.prz.aip.model.Dzial;

public interface DzialRepository extends CrudRepository<Dzial, Integer> {
	List<Dzial> findByNazwa(String nazwa);
}
