package com.demo.spring.jpa.msGenerate.service;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.jpa.msGenerate.exception.ResourceNotFoundException;
import com.demo.spring.jpa.msGenerate.model.*;

import com.demo.spring.jpa.msGenerate.repository.*;

@Service
public class TutorialDetailService{

@Autowired
TutorialDetailRepository tutorialdetailRepository;

public List<TutorialDetail> getAllTutorialDetails() {
	return tutorialdetailRepository.findAll();
}

public TutorialDetail createTutorialDetail(TutorialDetail tutorialdetail) {
TutorialDetail newTutorialDetail = new TutorialDetail(tutorialdetail.getCreatedby());
	return tutorialdetailRepository.save(newTutorialDetail);
}

}
