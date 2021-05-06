package com.example.Health4U.repository;

import com.example.Health4U.dao.FichePatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichePatientRepository extends JpaRepository<FichePatient, Integer> {
}
