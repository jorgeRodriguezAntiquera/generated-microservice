package com.demo.spring.jpa.msGenerate.model;

import javax.persistence.*;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "TutorialLists")
public class TutorialList{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
@Column(name = "createdBy")
private String createdBy;

public TutorialList(String createdBy) {
	this.createdBy = createdBy;
}

public TutorialList(){}

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
	return "TutorialList [ id=" + id + " ,  createdBy=" + createdBy + " ]";
}

}
