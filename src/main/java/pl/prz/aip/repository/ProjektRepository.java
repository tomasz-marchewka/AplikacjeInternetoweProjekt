package pl.prz.aip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.prz.aip.model.Projekt;

public interface ProjektRepository extends JpaRepository<Projekt, Integer> {
}
