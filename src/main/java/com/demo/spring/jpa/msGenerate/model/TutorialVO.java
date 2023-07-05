package com.demo.spring.jpa.msGenerate.model;

import javax.persistence.*;

import java.util.*;

@Embeddable
@Table(name = "TutorialVOs")
public class TutorialVO{

@Column(name = "createdBy")
private String createdBy;

public TutorialVO(String createdBy) {
	this.createdBy = createdBy;
}

public TutorialVO(){}

 public String getCreatedby() {
	return this.createdBy;
}


 public String setCreatedby(String createdBy) {
	return this.createdBy = createdBy;
}


@Override
public String toString() {
	return "TutorialVO [ createdBy=" + createdBy + " ]";
}

}
