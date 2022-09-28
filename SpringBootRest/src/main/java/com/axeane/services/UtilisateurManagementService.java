package com.axeane.services;


import com.axeane.model.Utilisateur;
import com.axeane.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurManagementService {


    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurManagementService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Transactional
    public void deleteUserById(Long Id) throws UsernameNotFoundException
    {
        utilisateurRepository.deleteById(Id);
        utilisateurRepository.flush();

    }
    @Transactional
    public Utilisateur addUser(Utilisateur user) throws UsernameNotFoundException
    {
        String username = user.getUsername();
        List<Utilisateur> userComparator = utilisateurRepository.findByUsername(username); //searching for users by username
        if(userComparator.size()!=0) // this value indicates whether the user exists or not. username must be unique.
        {
            throw new UsernameNotFoundException("username: "+username+" already exists."); //throwing exception if username exists already
        }
        else {
            return utilisateurRepository.saveAndFlush(user);
        }
    }

    @Transactional
    public Utilisateur updateUser(Utilisateur newUser) throws UsernameNotFoundException
    {
        Long id = newUser.getId();
        Optional<Utilisateur> user = utilisateurRepository.findById((long) id); //searching for users by id
        String username = newUser.getUsername();
        List<Utilisateur> userComparator = utilisateurRepository.findByUsername(username); //searching for users having same username

        if (user.isPresent()&&(((userComparator.size()==1)&&(userComparator.get(0).getId()==id))||(userComparator.size()==0)))
        {
            user.get().setUsername(newUser.getUsername()); //inserting new values in variable extracted by "findById()" method
            user.get().setEmail(newUser.getEmail());       //in order to have the ability to update the values in the database
            user.get().setName(newUser.getName());        //instead of adding a new one.
            user.get().setLast_name(newUser.getLast_name());
            user.get().setEnabled(newUser.getEnabled());
            user.get().setRole(newUser.getRole());


            return utilisateurRepository.saveAndFlush(user.get());
        }
        else {
            throw new UsernameNotFoundException("username: "+username+" already exists.");
        }




    }

    public List<Utilisateur> findAllUsers()
    {
        Iterable<Utilisateur> users = utilisateurRepository.findAll();
        List<Utilisateur> usersList = new ArrayList<Utilisateur>();
        users.forEach(usersList::add);
        usersList.forEach(user-> user.setPassword(null)); //setting returned password to null for security
        return usersList;
    }

    public Utilisateur getCurrentUser()
    {
        Utilisateur currentUser = utilisateurRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
        return currentUser;
    }
}
