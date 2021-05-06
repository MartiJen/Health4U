package com.example.Health4U.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fichePatient")
@AllArgsConstructor
@NoArgsConstructor
public class FichePatient {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer numSecu;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String dateNaissance;

    @Column
    private String groupeSanguin;

    @Column
    private String sexe;

}
