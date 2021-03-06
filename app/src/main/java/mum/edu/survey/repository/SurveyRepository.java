package com.hellokoding.springboot.repository;

import com.hellokoding.springboot.model.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

}

