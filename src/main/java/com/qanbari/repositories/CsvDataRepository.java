package com.qanbari.repositories;

import com.qanbari.entities.CsvData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CsvDataRepository extends JpaRepository<CsvData, Long> {
    Optional<CsvData> findByCode(String code);
}
