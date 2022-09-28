package com.axeane.configuration;

import com.axeane.model.Utilisateur;
import com.axeane.model.UtilisateurDetails;
import com.axeane.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilisateurDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        List<Utilisateur> user = utilisateurRepository.findByUsername(username); //searching for users by username
        if(user.size()==0) // this value indicates whether the user exists or not
        {
            throw new UsernameNotFoundException("could not find user "+username+"."); //throwing exception if user does not exist
        }
        return new UtilisateurDetails(user.get(0)); //returning first user that matches the given username
    }


}
