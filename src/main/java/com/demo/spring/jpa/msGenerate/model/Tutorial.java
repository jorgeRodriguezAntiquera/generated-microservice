package com.demo.spring.jpa.msGenerate.model;

import javax.persistence.*;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "Tutorials")
public class Tutorial{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private long id;

@Column(name = "title")
private String title;

@Column(name = "description")
private String description;

/*@OneToOne(fetch = FetchType.LAZY)
@MapsId
@JoinColumn(name = "tiene_id")
private TutorialDetail Tiene;*/

/*  @ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "tiene_id") 
private List<TutorialList> Tiene;*/


public Tutorial(String title, String description, ) {
	this.title = title;
	this.description = description;
}

public Tutorial(){}

public  void  test (    ){ }

 public long getId() {
	return this.id;
}


 public String getTitle() {
	return this.title;
}


 public String getDescription() {
	return this.description;
}


 public long setId(long id) {
	return this.id = id;
}


 public String setTitle(String title) {
	return this.title = title;
}


 public String setDescription(String description) {
	return this.description = description;
}


}
