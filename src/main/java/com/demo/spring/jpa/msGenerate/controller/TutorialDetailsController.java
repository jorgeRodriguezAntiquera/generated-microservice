package com.demo.spring.jpa.msGenerate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.spring.jpa.msGenerate.exception.ResourceNotFoundException;
import com.demo.spring.jpa.msGenerate.model.TutorialDetails;
import com.demo.spring.jpa.msGenerate.model.Tutorial;
import com.demo.spring.jpa.msGenerate.repository.TutorialDetailsRepository;
import com.demo.spring.jpa.msGenerate.repository.TutorialRepository;
import com.demo.spring.jpa.msGenerate.service.TutorialDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialDetailsController {
  @Autowired
  private TutorialDetailsRepository detailsRepository;

  @Autowired
  private TutorialRepository tutorialRepository;

  @Autowired
  TutorialDetailsService tutorialDetailsService;
  

  @GetMapping({ "/{id}/details", "/details/{id}" })
    public ResponseEntity<TutorialDetails> getDetailsById(@PathVariable(value = "id") Long id) {
        TutorialDetails details = tutorialDetailsService.getDetailsById(id);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

  @PostMapping("/{tutorialId}/details")
    public ResponseEntity<TutorialDetails> createDetails(@PathVariable(value = "tutorialId") Long tutorialId,
            @RequestBody TutorialDetails detailsRequest) {
        TutorialDetails createdDetails = tutorialDetailsService.createDetails(tutorialId, detailsRequest);
        return new ResponseEntity<>(createdDetails, HttpStatus.CREATED);
    }

    @GetMapping("/details")
    public ResponseEntity<List<TutorialDetails>> getAllDetails() {
        List<TutorialDetails> details = tutorialDetailsService.getAllDetails();
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

  /* @PutMapping("/details/{id}")
  public ResponseEntity<TutorialDetails> updateDetails(@PathVariable("id") long id,
      @RequestBody TutorialDetails detailsRequest) {
    TutorialDetails details = detailsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));

    details.setCreatedBy(detailsRequest.getCreatedBy());

    return new ResponseEntity<>(detailsRepository.save(details), HttpStatus.OK);
  }

  @DeleteMapping("/details/{id}")
  public ResponseEntity<HttpStatus> deleteDetails(@PathVariable("id") long id) {
    detailsRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/tutorials/{tutorialId}/details")
  public ResponseEntity<TutorialDetails> deleteDetailsOfTutorial(@PathVariable(value = "tutorialId") Long tutorialId) {
    if (!tutorialRepository.existsById(tutorialId)) {
      throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
    }

    detailsRepository.deleteByTutorialId(tutorialId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } */
}
