package com.example.Health4U.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichePatientDto {

    private Integer id;

    private Integer numSecu;

    private String nom;

    private String prenom;

    private String dateNaissance;

    private String groupeSanguin;

    private String sexe;
}
