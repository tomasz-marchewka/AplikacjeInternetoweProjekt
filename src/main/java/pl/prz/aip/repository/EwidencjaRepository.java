package pl.prz.aip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.prz.aip.model.Ewidencja;

public interface EwidencjaRepository extends JpaRepository<Ewidencja, Integer> {
}
