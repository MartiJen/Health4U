package com.example.Health4U.services;

import com.example.Health4U.dao.FichePatient;
import com.example.Health4U.dtos.FichePatientDto;
import com.example.Health4U.exceptions.M2I404Exception;

import java.util.List;

public interface FichePatientService {
    List<FichePatientDto> findAll();

    FichePatientDto findById(Integer id) throws M2I404Exception;

    FichePatientDto create(FichePatientDto fichePatientDto);

    FichePatientDto update(Integer id, FichePatientDto fichePatientDto) throws M2I404Exception;

    void delete(Integer id) throws M2I404Exception;

    FichePatientDto findByName();

    FichePatientDto findByLastName();

    FichePatientDto findByNumSecu();

    FichePatientDto findByBirthDate();
}
