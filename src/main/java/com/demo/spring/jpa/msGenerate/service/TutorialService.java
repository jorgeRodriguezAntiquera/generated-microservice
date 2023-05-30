package com.demo.spring.jpa.msGenerate.service;
import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.spring.jpa.msGenerate.exception.ResourceNotFoundException;
import com.demo.spring.jpa.msGenerate.model.*;

import com.demo.spring.jpa.msGenerate.repository.TutorialRepository;

@Service
public class TutorialService {

    @Autowired
    TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public List<Tutorial> getAllTutorials(String title) {
        List<Tutorial> tutorials = new ArrayList<>();

        if (title == null) {
            tutorialRepository.findAll().forEach(tutorials::add);
        } else {
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
        }

        return tutorials;
    }

    public Tutorial getTutorialById(long id) {
        return tutorialRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
    }

    public Tutorial createTutorial(Tutorial tutorial) {
        Tutorial newTutorial = new Tutorial(tutorial.getTitle(), tutorial.getDescription(), true);
        return tutorialRepository.save(newTutorial);
    }

    
}