package com.demo.spring.jpa.msGenerate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.jpa.msGenerate.exception.ResourceNotFoundException;
import com.demo.spring.jpa.msGenerate.model.Tutorial;
import com.demo.spring.jpa.msGenerate.model.TutorialDetails;
import com.demo.spring.jpa.msGenerate.repository.TutorialDetailsRepository;
import com.demo.spring.jpa.msGenerate.repository.TutorialRepository;

@Service
public class TutorialDetailsService {
    
    @Autowired
    TutorialDetailsRepository detailsRepository;

    @Autowired
    TutorialRepository tutorialRepository;

    public TutorialDetailsService(TutorialDetailsRepository detailsRepository, TutorialRepository tutorialRepository) {
        this.detailsRepository = detailsRepository;
        this.tutorialRepository = tutorialRepository;
    }

    public TutorialDetails getDetailsById(Long id) {
        return detailsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial Details with id = " + id));
    }

    public TutorialDetails createDetails(Long tutorialId, TutorialDetails detailsRequest) {
        Tutorial tutorial = tutorialRepository.findById(tutorialId)
            .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));

        detailsRequest.setCreatedOn(new java.util.Date());
        detailsRequest.setTutorial(tutorial);
        return detailsRepository.save(detailsRequest);
    }

    public List<TutorialDetails> getAllDetails() {
        return detailsRepository.findAll();
    }
   

    
}
