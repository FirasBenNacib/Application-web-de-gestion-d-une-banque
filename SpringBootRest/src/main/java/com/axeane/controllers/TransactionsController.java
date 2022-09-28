package com.axeane.controllers;
import com.axeane.model.Transaction;
import com.axeane.services.TransactionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.zalando.problem.ProblemModule;
//import org.zalando.problem.validation.ConstraintViolationProblemModule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransactionsController {

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer problemObjectMapperModules() {
//        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.modules(
//                new ProblemModule(),
//                new ConstraintViolationProblemModule());
//    }

    private TransactionsService transactionsService;

    public void ComptesService(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/numerocomptes/{numerocompteId}/transactions")
    public ResponseEntity getAllComptesByNumerocompteId(@PathVariable(value = "numerocompteId") Long numerocompteId, Pageable pageable) {

       // Page<Transaction> comptes = transactionsService.getAllNumerocomptesByAgencetId(agenceId, pageable);

        Page<List<Transaction>> comptes = transactionsService.findComptesByNumerocompte(numerocompteId,pageable);

        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }
    @PostMapping("/numerocomptes/{numerocompteId}/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCompte(@PathVariable(value = "numerocompteId") Long numerocompteId,
                                       @RequestBody Transaction compte) {
        transactionsService.addcompte(numerocompteId, compte);
        return new ResponseEntity<>(compte, HttpStatus.CREATED);
    }


    @PutMapping("/numerocomptes/{numerocompteId}/transactions/{transactionId}")
    public ResponseEntity updateCompte(@PathVariable(value = "numerocompteId") Long numerocompteId,
                                       @RequestBody Transaction compteRequest) {
       transactionsService.updateCompte(numerocompteId, compteRequest);
        return new ResponseEntity<>(compteRequest, HttpStatus.OK);
    }


    @DeleteMapping("/numerocomptes/{numerocompteId}/transactions/{transactionId}")
    public ResponseEntity deleteNumerocompte(@PathVariable(value = "numerocompteId") Long numerocompteId,
                                        @PathVariable(value = "transactionId") Long compteId) {
       transactionsService.deleteCompted(numerocompteId, compteId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/transactions/{id}")
    public ResponseEntity findCompte(@PathVariable(value = "id") Long id) {
        Transaction comptes = transactionsService.findCompteById(id);

        return new ResponseEntity<>(comptes,HttpStatus.OK);
    }
}