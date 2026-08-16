package pl.prz.aip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.prz.aip.model.Pracownik;

public interface PracownikRepository extends JpaRepository<Pracownik, Integer> {
}
