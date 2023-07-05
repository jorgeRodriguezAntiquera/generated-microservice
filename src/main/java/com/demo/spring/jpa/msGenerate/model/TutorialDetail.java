package com.demo.spring.jpa.msGenerate.model;

import javax.persistence.*;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "TutorialDetails")
public class TutorialDetail{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
@Column(name = "createdBy")
private String createdBy;
private TutorialVO Tiene2;

public TutorialDetail(String createdBy, TutorialVO Tiene2) {
	this.createdBy = createdBy;
	this.Tiene2 = Tiene2;
}

public TutorialDetail(){}

 public long getId() {
	return this.id;
}


 public String getCreatedby() {
	return this.createdBy;
}


 public TutorialVO getTiene2() {
	return this.Tiene2;
}


 public long setId(long id) {
	return this.id = id;
}


 public String setCreatedby(String createdBy) {
	return this.createdBy = createdBy;
}


 public TutorialVO setTiene2(TutorialVO Tiene2) {
	return this.Tiene2 = Tiene2;
}


@Override
public String toString() {
	return "TutorialDetail [ id=" + id + " ,  createdBy=" + createdBy + " ,  Tiene2=" + Tiene2 + " ]";
}

}
