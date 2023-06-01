package com.demo.spring.jpa.msGenerate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.spring.jpa.msGenerate.model.*;
import com.demo.spring.jpa.msGenerate.repository.*;
import com.demo.spring.jpa.msGenerate.service.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialDetailController {

@Autowired
TutorialDetailService tutorialdetailService;

@GetMapping("/tutorialdetails")
public ResponseEntity<List<TutorialDetail>> getAllTutorialDetail() {
List<TutorialDetail> tutorialdetail = tutorialdetailService.getAllTutorialDetails();
	return new ResponseEntity<>(tutorialdetail, HttpStatus.OK);
}
@PostMapping("/tutorialdetails")
public ResponseEntity<TutorialDetail> createTutorialDetail(@RequestBody TutorialDetail tutorialdetail) {
TutorialDetail createdTutorialDetail = tutorialdetailService.createTutorialDetail(tutorialdetail);
	return new ResponseEntity<>(createdTutorialDetail, HttpStatus.CREATED);
}


}
