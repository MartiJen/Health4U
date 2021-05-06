package com.example.Health4U.controller;

import com.example.Health4U.dao.FichePatient;
import com.example.Health4U.dtos.FichePatientDto;
import com.example.Health4U.exceptions.M2I404Exception;
import com.example.Health4U.services.FichePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/patients")
@RestController
public class FichePatientController {

    @Autowired
    private FichePatientService fichePatientService;

    @GetMapping
    public List<FichePatientDto> getAll(){return fichePatientService.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public FichePatientDto getById(@PathVariable Integer id) throws M2I404Exception {
        return fichePatientService.findById(id);
    }

    @PostMapping
    public FichePatientDto create(@RequestBody FichePatientDto fichePatientDto) {return fichePatientService.create(fichePatientDto);}

    @PutMapping("/{id}")
    public FichePatientDto update(@PathVariable Integer id, @RequestBody FichePatientDto fichePatientDto) throws M2I404Exception{
        return fichePatientService.update(id, fichePatientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws M2I404Exception {
        fichePatientService.delete(id);
    }
}
