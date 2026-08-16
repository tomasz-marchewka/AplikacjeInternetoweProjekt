package pl.prz.aip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.prz.aip.model.PunktKluczowy;

public interface PunktKluczowyRepository extends JpaRepository<PunktKluczowy, Integer> {
}
