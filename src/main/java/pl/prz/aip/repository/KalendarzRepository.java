package pl.prz.aip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.prz.aip.model.Kalendarz;

public interface KalendarzRepository extends JpaRepository<Kalendarz, Integer> {
}
