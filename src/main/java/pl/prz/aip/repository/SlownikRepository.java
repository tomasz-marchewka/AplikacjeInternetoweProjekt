package pl.prz.aip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.prz.aip.model.Slownik;

public interface SlownikRepository extends JpaRepository<Slownik, Integer> {
}
