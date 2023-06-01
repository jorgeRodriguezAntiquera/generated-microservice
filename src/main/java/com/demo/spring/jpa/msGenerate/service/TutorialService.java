package com.demo.spring.jpa.msGenerate.service;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.jpa.msGenerate.exception.ResourceNotFoundException;
import com.demo.spring.jpa.msGenerate.model.*;

import com.demo.spring.jpa.msGenerate.repository.*;

@Service
public class TutorialService{

@Autowired
TutorialRepository tutorialRepository;

@Autowired
TutorialDetailRepository tutorialdetailRepository;

public List<Tutorial> getAllTutorials() {
	return tutorialRepository.findAll();
}

public Tutorial createTutorial(Long Id,Tutorial tutorialRequest) {
TutorialDetail setter = tutorialdetailRepository.findById(Id)
			.orElseThrow(() -> new ResourceNotFoundException("Not found with id = " + Id));

tutorialRequest.setTiene(setter);
	return tutorialRepository.save(tutorialRequest);
}

}
