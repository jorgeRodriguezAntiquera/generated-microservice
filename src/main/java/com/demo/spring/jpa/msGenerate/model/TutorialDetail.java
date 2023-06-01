package com.demo.spring.jpa.msGenerate.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "TutorialDetails")
public class TutorialDetail{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
@Column(name = "createdBy")
private String createdBy;

public TutorialDetail(String createdBy) {
	this.createdBy = createdBy;
}

public TutorialDetail(){}

 public long getId() {
	return this.id;
}


 public String getCreatedby() {
	return this.createdBy;
}


 public long setId(long id) {
	return this.id = id;
}


 public String setCreatedby(String createdBy) {
	return this.createdBy = createdBy;
}


@Override
public String toString() {
	return "TutorialDetail [ id=" + id + " ,  createdBy=" + createdBy + " ]";
}

}
