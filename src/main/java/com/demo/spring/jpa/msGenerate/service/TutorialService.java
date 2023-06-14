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

@Autowired
TutorialListRepository tutoriallistRepository;

public List<Tutorial> getAllTutorials() {
	return tutorialRepository.findAll();
}

public List<TutorialDetail> getAllTutorialDetails() {
	return tutorialdetailRepository.findAll();
}

public List<TutorialList> getAllTutorialLists() {
	return tutoriallistRepository.findAll();
}

public TutorialDetail createTutorialDetail(TutorialDetail tutorialdetail) {
TutorialDetail newTutorialDetail = new TutorialDetail(tutorialdetail.getCreatedby(),tutorialdetail.getTiene2());
	return tutorialdetailRepository.save(newTutorialDetail);
}

public TutorialList createTutorialList(TutorialList tutoriallist) {
TutorialList newTutorialList = new TutorialList(tutoriallist.getCreatedby());
	return tutoriallistRepository.save(newTutorialList);
}

public Tutorial createTutorial(Long Id,Tutorial tutorialRequest) {
	return null;
}

}
