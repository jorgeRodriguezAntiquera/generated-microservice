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
public class TutorialController {

@Autowired
TutorialService Service;

//GetAll EntityTutorialDetail
@GetMapping("/tutorialdetails")
public ResponseEntity<List<TutorialDetail>> getAllTutorialDetail() {
List<TutorialDetail> tutorialdetail = Service.getAllTutorialDetails();
return new ResponseEntity<>(tutorialdetail, HttpStatus.OK);
}

//GetAll EntityTutorialList
@GetMapping("/tutoriallists")
public ResponseEntity<List<TutorialList>> getAllTutorialList() {
List<TutorialList> tutoriallist = Service.getAllTutorialLists();
return new ResponseEntity<>(tutoriallist, HttpStatus.OK);
}

//Post EntityTutorialDetail
@PostMapping("/tutorialdetails")
public ResponseEntity<TutorialDetail> createTutorialDetail(@RequestBody TutorialDetail tutorialdetail) {
TutorialDetail createdtutorialdetail = Service.createTutorialDetail(tutorialdetail);
return new ResponseEntity<>(createdtutorialdetail, HttpStatus.CREATED);
}

//Post EntityTutorialList
@PostMapping("/tutoriallists")
public ResponseEntity<TutorialList> createTutorialList(@RequestBody TutorialList tutoriallist) {
TutorialList createdtutoriallist = Service.createTutorialList(tutoriallist);
return new ResponseEntity<>(createdtutoriallist, HttpStatus.CREATED);
}

@GetMapping("/tutorials")
public ResponseEntity<List<Tutorial>> getAllTutorial() {
List<Tutorial> tutorial = Service.getAllTutorials();
	return new ResponseEntity<>(tutorial, HttpStatus.OK);
}
@PostMapping("/{Id}/tutorials")
public ResponseEntity<Tutorial> createTutorial(@PathVariable(value = "Id") Long Id, @RequestBody Tutorial tutorial) {
Tutorial createdTutorial = Service.createTutorial(Id,tutorial);
	return new ResponseEntity<>(createdTutorial, HttpStatus.CREATED);
}


}
