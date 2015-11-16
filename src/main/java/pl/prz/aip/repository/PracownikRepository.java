package pl.prz.aip.repository;

import org.springframework.data.repository.CrudRepository;

import pl.prz.aip.model.Pracownik;

public interface PracownikRepository extends CrudRepository<Pracownik, Integer> {

}
