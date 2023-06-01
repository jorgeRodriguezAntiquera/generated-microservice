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
TutorialService tutorialService;

@GetMapping("/tutorials")
public ResponseEntity<List<Tutorial>> getAllTutorial() {
List<Tutorial> tutorial = tutorialService.getAllTutorials();
	return new ResponseEntity<>(tutorial, HttpStatus.OK);
}
@PostMapping("/{Id}/tutorials")
public ResponseEntity<Tutorial> createTutorial(@PathVariable(value = "Id") Long Id, @RequestBody Tutorial tutorial) {
Tutorial createdTutorial = tutorialService.createTutorial(Id,tutorial);
	return new ResponseEntity<>(createdTutorial, HttpStatus.CREATED);
}


}
