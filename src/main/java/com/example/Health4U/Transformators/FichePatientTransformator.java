package com.example.Health4U.Transformators;

import com.example.Health4U.dao.FichePatient;
import com.example.Health4U.dtos.FichePatientDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FichePatientTransformator {
    public FichePatientDto modelToDto(final FichePatient patient) {
        if(patient == null) {
            return null;
        }
        return new FichePatientDto(patient.getId(),
                patient.getNumSecu(),
                patient.getNom(),
                patient.getPrenom(),
                patient.getDateNaissance(),
                patient.getGroupeSanguin(),
                patient.getSexe());
    }

    public List<FichePatientDto> modelToDtos(final List<FichePatient> models) {
        return models.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    public FichePatient dtoToModel(final FichePatientDto dto) {
        if(dto == null) {
            return null;
        }
        return new FichePatient(dto.getId(),
                dto.getNumSecu(),
                dto.getNom(),
                dto.getPrenom(),
                dto.getDateNaissance(),
                dto.getGroupeSanguin(),
                dto.getSexe());
    }

    public List<FichePatient> dtosToModel(final List<FichePatientDto> dtos) {
        return dtos.stream().map(this::dtoToModel).collect(Collectors.toList());
    }

}
