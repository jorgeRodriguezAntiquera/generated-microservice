package com.demo.spring.jpa.msGenerate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.spring.jpa.msGenerate.model.*;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>{}
