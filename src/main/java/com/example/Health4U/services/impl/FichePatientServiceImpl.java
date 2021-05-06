package com.example.Health4U.services.impl;

import com.example.Health4U.Transformators.FichePatientTransformator;
import com.example.Health4U.dao.FichePatient;
import com.example.Health4U.dtos.FichePatientDto;
import com.example.Health4U.exceptions.M2I404Exception;
import com.example.Health4U.repository.FichePatientRepository;
import com.example.Health4U.services.FichePatientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class FichePatientServiceImpl implements FichePatientService {

    private FichePatientRepository fichePatientRepository;
    private FichePatientTransformator fichePatientTransformateur;

    public FichePatientServiceImpl(FichePatientRepository fichePatientRepository, FichePatientTransformator fichePatientTransformer) {
        this.fichePatientRepository = fichePatientRepository;
        this.fichePatientTransformateur = fichePatientTransformer;
    }

    @Override
    public List<FichePatientDto> findAll() {
        return fichePatientTransformateur.modelToDtos(fichePatientRepository.findAll());
    }


    @Override
    public FichePatientDto findById(Integer id) throws M2I404Exception {
        Optional<FichePatient> byId = fichePatientRepository.findById(id);
        return fichePatientTransformateur.modelToDto(byId.orElseThrow(() -> new M2I404Exception("Le produit "
                + id + " n'existe pas")));
    }

    @Override
    public FichePatientDto create(FichePatientDto fichePatientDto) {
        FichePatient fichePatient = fichePatientTransformateur.dtoToModel(fichePatientDto);
        return fichePatientTransformateur.modelToDto(fichePatientRepository.save(fichePatient));
    }

    @Override
    public FichePatientDto update(Integer id, FichePatientDto fichePatientDto) throws M2I404Exception {
        FichePatient p = fichePatientRepository.findById(id).orElseThrow(() -> new M2I404Exception("Le produit "
                + id + " n'existe pas"));
        p.setNumSecu(p.getNumSecu());
        p.setNom(p.getNom());
        p.setPrenom(p.getPrenom());
        p.setDateNaissance(p.getDateNaissance());
        p.setGroupeSanguin(p.getGroupeSanguin());
        p.setSexe(p.getSexe());
        /*p.setTitle(p.getTitle());
        p.setQuantity(p.getQuantity());*/
        return fichePatientTransformateur.modelToDto(fichePatientRepository.save(p));
    }

    @Override
    public void delete(Integer id) throws M2I404Exception {
        FichePatient product = fichePatientRepository.findById(id).orElseThrow(() -> new M2I404Exception("Le produit "
                + id + " n'existe pas"));
        fichePatientRepository.delete(product);

    }

    @Override
    public FichePatientDto findByName() {
        return null;
    }

    @Override
    public FichePatientDto findByLastName() {
        return null;
    }

    @Override
    public FichePatientDto findByNumSecu() {
        return null;
    }

    @Override
    public FichePatientDto findByBirthDate() {
        return null;
    }
}
