package pl.prz.aip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.prz.aip.model.Dzial;

public interface DzialRepository extends JpaRepository<Dzial, Integer> {

	List<Dzial> findByNazwa(String nazwa);
}
