package com.axeane.services;
import com.axeane.model.Agence;
import com.axeane.repositories.AgenceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgenceServiceImpl implements AgenceService {
    private final AgenceRepository agenceRepository;

    public AgenceServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Page<Agence> getAllAgences(Pageable pageable) {
        return agenceRepository.findAll(pageable);
    }

    @Override
    public void createAgence(Agence agence) {
       agenceRepository.save(agence);
    }

    @Override
    public void updateAgence(Agence agenceRequest) {
        agenceRepository.findById(agenceRequest.getId()).map(agence -> {
            agence.setNom(agenceRequest.getNom());
            agence.setDescription(agenceRequest.getDescription());
            return agenceRepository.save(agence);
        });
    }

    @Override
    public void deleteAgence(Long agenceId) {
        agenceRepository.findById(agenceId).map(agence -> {
            agenceRepository.delete(agence);
            return agence;
        });
    }

        @Override
        public Agence registerAgence(Agence agence) {
            return agenceRepository.save(agence);
        }
    }


