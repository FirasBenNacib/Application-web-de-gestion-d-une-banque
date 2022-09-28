package com.axeane.controllers;

import com.axeane.configuration.UtilisateurDetailsService;
import com.axeane.model.AuthenticationRequest;
import com.axeane.model.AuthenticationResponse;
import com.axeane.model.Utilisateur;
import com.axeane.model.UtilisateurDetails;
import com.axeane.repositories.UtilisateurRepository;
import com.axeane.services.JwtUtil;
import com.axeane.services.UtilisateurManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Login {
    private UtilisateurManagementService appUserManagementService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UtilisateurDetailsService userDetailsService;

    @Autowired
    private UtilisateurRepository repo;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
    {
        System.out.println(authenticationRequest.toString());
        try {
            System.out.println(authenticationRequest.getUsername());
            System.out.println(authenticationRequest.getPassword());
            System.out.println(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            System.out.println(authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            ));
        }
        catch (BadCredentialsException e) {
            System.out.println("Incorrect username or password");
            throw new Exception("Incorrect username or password", e);

        }
        final UtilisateurDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        Utilisateur user=repo.findByUsername(userDetails.getUsername()).get(0);
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt,user));

    }
}
