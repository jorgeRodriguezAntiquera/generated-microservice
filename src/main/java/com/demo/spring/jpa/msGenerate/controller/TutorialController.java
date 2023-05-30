package com.demo.spring.jpa.msGenerate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.spring.jpa.msGenerate.exception.ResourceNotFoundException;
import com.demo.spring.jpa.msGenerate.model.Tutorial;
import com.demo.spring.jpa.msGenerate.repository.TutorialDetailsRepository;
import com.demo.spring.jpa.msGenerate.repository.TutorialRepository;
import com.demo.spring.jpa.msGenerate.service.TutorialService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialRepository tutorialRepository;
  
  @Autowired
  private TutorialDetailsRepository detailsRepository;

  @Autowired
  TutorialService tutorialService;

  @GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {

    List<Tutorial> tutorials = tutorialService.getAllTutorials(title);

    if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(tutorials, HttpStatus.OK);
  
  }

 

  @GetMapping("/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
      Tutorial tutorial = tutorialService.getTutorialById(id);
      return new ResponseEntity<>(tutorial, HttpStatus.OK);
  }

 

  @PostMapping("/tutorials")
  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
      Tutorial createdTutorial = tutorialService.createTutorial(tutorial);
      return new ResponseEntity<>(createdTutorial, HttpStatus.CREATED);
  }

  /* @PutMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
    Tutorial _tutorial = tutorialRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

    _tutorial.setTitle(tutorial.getTitle());
    _tutorial.setDescription(tutorial.getDescription());
    _tutorial.setPublished(tutorial.isPublished());
    
    return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
  }

  @DeleteMapping("/tutorials/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    if (detailsRepository.existsById(id)) {
      detailsRepository.deleteById(id);
    }
    
    tutorialRepository.deleteById(id);
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/tutorials")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    tutorialRepository.deleteAll();
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/tutorials/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
    List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

    if (tutorials.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<>(tutorials, HttpStatus.OK);
  } */
}
