package com.axeane.controllers;

import com.axeane.model.Agence;
import com.axeane.services.AgenceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AgenceController {


    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }



    @GetMapping("/agences")
    public ResponseEntity getAllAgences(Pageable pageable) {
        Page<Agence> agences = agenceService.getAllAgences(pageable);
        return new ResponseEntity<>(agences, HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/agences")
    public ResponseEntity creatAgence( @RequestBody Agence agence) {
        agenceService.createAgence(agence);
        return new ResponseEntity<>(agence, HttpStatus.CREATED);
    }


    @PutMapping("/agences")
    public ResponseEntity updateAgence(@RequestBody Agence agence) {
        agenceService.updateAgence(agence);
        return new ResponseEntity<>(agence, HttpStatus.OK); }

    @DeleteMapping("/agences/{agenceId}")
    public ResponseEntity deleteAgence(@PathVariable(value = "agenceId") Long agenceId) {
       agenceService.deleteAgence(agenceId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/registerAgence")
    public Agence registerAgence(@RequestBody Agence agence) {
       return agenceService.registerAgence(agence);
    }
}