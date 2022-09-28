package com.axeane.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String jwt;
    private Utilisateur user;

    public AuthenticationResponse(String jwt, Utilisateur user) {
        this.jwt = jwt;
        this.user= user;
    }

    public String getJwt() {
        return jwt;
    }

    /**
     * @return the userId
     */
    public Utilisateur getUser() {
        return user;
    }




}
