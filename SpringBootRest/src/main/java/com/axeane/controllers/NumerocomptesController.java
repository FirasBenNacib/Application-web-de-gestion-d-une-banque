package com.axeane.controllers;

import com.axeane.model.Numerocompte;
import com.axeane.services.NumerocomptesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NumerocomptesController {
    public NumerocomptesController(NumerocomptesService numerocomptesService) {
        this.numerocomptesService = numerocomptesService;
    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer problemObjectMapperModules() {
//        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.modules(
//                new ProblemModule(),
//                new ConstraintViolationProblemModule());
//    }

    private NumerocomptesService numerocomptesService;

    public void AgenceService(NumerocomptesService numerocomptesService) {
        this.numerocomptesService = numerocomptesService;
    }

    @GetMapping("/agences/{agenceId}/numerocomptes")
    public ResponseEntity getAllNumerocomptesByAgenceId(@PathVariable(value = "agenceId") Long agenceId, Pageable pageable) {

        //Page<Numerocompte> numerocomptes = numerocomptesService.getAllNumerocomptesByAgencetId(agenceId, pageable);

        Page<List<Numerocompte>> numerocomptes = numerocomptesService.findNumerocomptesByAgence(agenceId,pageable);

        return new ResponseEntity<>(numerocomptes, HttpStatus.OK);
    }
    @PostMapping("/agences/{agenceId}/numerocomptes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCompte(@PathVariable(value = "agenceId") Long agenceId,
                                       @RequestBody Numerocompte numerocompte) {
        numerocomptesService.addnumerocompte(agenceId, numerocompte);
        return new ResponseEntity<>(numerocompte, HttpStatus.CREATED);
    }


    @PutMapping("/agences/{agenceId}/numercomptes/{numercompteId}")
    public ResponseEntity updateNumerocompte(@PathVariable(value = "agenceId") Long agenceId,
                                       @RequestBody Numerocompte numerocompteRequest) {
        numerocomptesService.updateNumerocompte(agenceId, numerocompteRequest);
        return new ResponseEntity<>(numerocompteRequest, HttpStatus.OK);
    }


    @DeleteMapping("/agences/{agenceId}/numerocomptes/{numerocompteId}")
    public ResponseEntity deleteNumerocompte(@PathVariable(value = "agenceId") Long agenceId,
                                             @PathVariable(value = "numerocompteId") Long numerocompteId) {
        numerocomptesService.deleteNumerocompted(agenceId, numerocompteId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/numerocomptes/{id}")
    public ResponseEntity findNumerocompte(@PathVariable(value = "id") Long id) {
        Numerocompte numerocomptes = numerocomptesService.findNumerocompteById(id);

        return new ResponseEntity<>(numerocomptes,HttpStatus.OK);
    }


}
